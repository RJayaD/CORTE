package com.example.corte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.corte.Adaptadores.AdapterEdicion;
import com.example.corte.Adaptadores.AdapterRecycler;
import com.example.corte.Models.Datum;
import com.example.corte.Models.Edicion;
import com.example.corte.WebService.Asynchtask;
import com.example.corte.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class MainActivity2 extends AppCompatActivity implements Asynchtask {

    private RecyclerView recyclerView;
    private AdapterEdicion adapteredic;
    ArrayList<Edicion> listEdic;
    Intent intent;
    Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b = this.getIntent().getExtras();
        recyclerView = (RecyclerView)findViewById(R.id.rec_edic);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity2.this));
        handleSSLHandshake();
        InvokeWs();
    }

    private void InvokeWs(){
        String url ="https://revistas.uteq.edu.ec/ws/issues.php?j_id="+b.getString("journal_id");
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService(url, datos, this, MainActivity2.this);
        ws.execute("GET");
    }


    public static void handleSSLHandshake() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

                @Override
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }};

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }
            });
        } catch (Exception ignored) {
        }
    }

    @Override
    public void processFinish(String result) throws JSONException {
        try {
            intent= new Intent(this, Categorias.class);
            JSONArray jsonlista= new JSONArray(result);
            listEdic = Edicion.JsonObjectsBuild(jsonlista);
            adapteredic= new AdapterEdicion(getApplicationContext(), listEdic);
            adapteredic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    b=new Bundle();
                    b.putString("idIS",   listEdic.get(recyclerView.getChildAdapterPosition(v)).getIssueId());
                    intent.putExtras(b);
                    Toast.makeText(getApplicationContext(),"Seleccionó la edición:"
                            + listEdic.get(recyclerView.getChildAdapterPosition(v)).getTitle(),Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            });
            recyclerView.setAdapter(adapteredic);

        }catch (JSONException e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }
    }
}
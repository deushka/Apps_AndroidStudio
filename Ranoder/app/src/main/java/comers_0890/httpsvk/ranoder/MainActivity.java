package comers_0890.httpsvk.ranoder;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;


public class MainActivity extends ActionBarActivity {

    private Button button1, button2, nebesa, sliz, imperator;
    private MyTask mt;

    private TextView textView;
    String prev, next;
    private String filename;
    String curUrl="";

    @Override
    public void onBackPressed(){

    }

    void nextStep(){
        try{
            FileInputStream fIn = openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fIn);

            StringWriter writer = new StringWriter();
            IOUtils.copy(isr, writer);
            curUrl = writer.toString();
        } catch (FileNotFoundException e) {
            try {
                FileOutputStream fout = openFileOutput(filename, MODE_WORLD_READABLE);
                OutputStreamWriter osw = new OutputStreamWriter(fout);
                osw.write(curUrl);
                osw.flush();
                osw.close();
            } catch (FileNotFoundException E) {

            } catch (IOException E) {

            }
        } catch (IOException e) {

        }


        button1 = (Button)findViewById(R.id.buttonP);
        button2 = (Button) findViewById(R.id.buttonN);
        textView = (TextView)findViewById(R.id.textView1);
        textView.setMovementMethod(new ScrollingMovementMethod());
        mt = (MyTask) new MyTask(curUrl).execute();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mt.cancel(true);
                mt = (MyTask) new MyTask(prev).execute();
                textView.scrollTo(0, 0);
                try {
                    FileOutputStream fout = openFileOutput(filename, MODE_WORLD_READABLE);
                    OutputStreamWriter osw = new OutputStreamWriter(fout);
                    osw.write(prev);
                    osw.flush();
                    osw.close();
                } catch (FileNotFoundException e) {

                } catch (IOException e) {

                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mt.cancel(true);
                mt = (MyTask) new MyTask(next).execute();
                textView.scrollTo(0, 0);
                try {
                    FileOutputStream fout = openFileOutput(filename, MODE_WORLD_READABLE);
                    OutputStreamWriter osw = new OutputStreamWriter(fout);
                    osw.write(next);
                    osw.flush();
                    osw.close();
                } catch (FileNotFoundException e) {

                } catch (IOException e) {

                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);


        imperator = (Button) findViewById(R.id.button);
        nebesa = (Button) findViewById(R.id.button2);
        sliz = (Button) findViewById(R.id.button3);

        imperator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filename = "last.txt";
                curUrl = "http://xn--80ac9aeh6f.xn--p1ai/vlast-imperatora/noindex-glava-2-povelitel-trekh-demonov-chast-2/";
                setContentView(R.layout.activity_main);
                nextStep();
            }
        });

        nebesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filename = "menhao.txt";
                curUrl = "http://xn--80ac9aeh6f.xn--p1ai/i-shall-seal-the-heavens/glava-2-sekta-pokrovitelya/";
                setContentView(R.layout.activity_main);
                nextStep();
            }
        });

        sliz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filename = "slime.txt";
                curUrl = "http://xn--80ac9aeh6f.xn--p1ai/tensei-shitara-slime-datta-ken/noindex-glava-1-davayte-posmotrim-na-chto-ya-sposoben/";
                setContentView(R.layout.activity_main);
                nextStep();
            }
        });
    }

    class MyTask extends AsyncTask<Void, Void, Void> {

        private String title, url;

        public MyTask(String u){
            url=u;
        }

        @Override
        protected Void doInBackground(Void... params) {
            Document doc = null;
            try {
                doc = Jsoup.connect(url).get();
                System.out.println(doc);
            } catch (IOException e) {

            }

            if (doc!=null) {
                title="";
                Element div = doc.select("div.content__block").first();
                Elements parag = div.children();
                for (Element em:parag){
                    if (em.toString().charAt(1)=='p')
                        title+="  "+em+"\n";
                }
                title = doc.select("div.title>h1>p").first().toString()+"\n\n"+title;
                int pos = title.indexOf("<");
                int pos2 = title.indexOf(">");
                while(pos2!=-1) {
                    title = title.substring(0, pos) + title.substring(pos2 + 1);
                    pos = title.indexOf("<");
                    pos2 = title.indexOf(">");
                }
                Element cur = doc.select("li>a.btn-nav").first();
                prev = cur.attr("abs:href");
                cur = doc.select("li.next-part>a").first();
                next = cur.attr("abs:href");
            }
            else
                title = "Ошибка";
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            textView.setText(title);
        }
    }
}
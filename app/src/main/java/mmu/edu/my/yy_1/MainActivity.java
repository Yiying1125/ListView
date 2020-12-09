package mmu.edu.my.yy_1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String []mTitle={"Whatsapp","WeChat","Instagram","Youtube","Messenger"};
    String []mDesc={"Whatsapp description","WeChat description","Instagram description","Youtube description","Messenger description"};
    int []icons={R.drawable.whatsapp,R.drawable.wechat,R.drawable.instagram,R.drawable.youtube,R.drawable.messenger};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        MyAdapter adapter=new MyAdapter(this,mTitle,mDesc,icons);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent,view,position,id)->{
            if(position==0)
                Toast.makeText(MainActivity.this,"Whatsapp was press",Toast.LENGTH_SHORT).show();
            else if (position==1)
                 Toast.makeText(MainActivity.this,"Wechat was press",Toast.LENGTH_SHORT).show();
            else if (position==2)
                Toast.makeText(MainActivity.this,"Instagram was press",Toast.LENGTH_SHORT).show();
            else if (position==3)
                 Toast.makeText(MainActivity.this,"YouTube was press",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this,"Messenger was press",Toast.LENGTH_SHORT).show();
        });

    }
}

class MyAdapter extends ArrayAdapter<String>{
    Context context;
    String []rTitle;
    String []rDesc;
    int []rImgs;

    MyAdapter(Context c, String []title,String []Desc,int []imgs){
        super(c,R.layout.row,R.id.title,title);
        this.context=c;
        this.rTitle=title;
        this.rDesc=Desc;
        this.rImgs=imgs;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater=(LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=layoutInflater.inflate(R.layout.row,parent,false);
        ImageView images=row.findViewById(R.id.images);
        TextView myTitle=row.findViewById(R.id.title);
        TextView myDesc=row.findViewById(R.id.desc);
        images.setImageResource(rImgs[position]);
        myTitle.setText(rTitle[position]);
        myDesc.setText(rDesc[position]);
        return row;
    }


}

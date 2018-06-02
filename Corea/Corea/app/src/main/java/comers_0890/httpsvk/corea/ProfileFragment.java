package comers_0890.httpsvk.corea;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Asus on 08.04.2018.
 */

public class ProfileFragment extends Fragment {
    private ImageView mImageView=null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_home,null);
        mImageView = v.findViewById (R.id.imageView1);
        Button mButton = v.findViewById(R.id.button1);

        //mImageView.setImageResource(R.drawable.ava); //Cause an error
        return inflater.inflate(R.layout.fragment_profile, null);
    }
    public void dialogNew(View v){
        Toast toast = Toast.makeText(getActivity(),
                "Пора покормить кота!", Toast.LENGTH_SHORT);
        toast.show();
    }


}

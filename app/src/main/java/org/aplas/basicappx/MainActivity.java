package org.aplas.basicappx;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Distance dist = new Distance();
    private Weight weight = new Weight();
    private Temperature temp = new Temperature();
    private Button convertBtn;
    private EditText inputTxt;
    private EditText outputTxt;
    private Spinner unitOri;
    private Spinner unitConv;
    private RadioGroup unitType;
    private CheckBox roundBox;
    private CheckBox formBox;
    private ImageView imgView;
    private AlertDialog startDialog;

    protected double convertUnit(String type, String oriUnit, String convUnit, double value){
        double convert = 0;
        if(type.equalsIgnoreCase("Temperature")){
            convert = temp.convert(oriUnit, convUnit, value);
        } else if (type.equalsIgnoreCase("Distance")){
            convert = dist.convert(oriUnit, convUnit, value);
        } else if (type.equalsIgnoreCase("Weight")){
            convert = weight.convert(oriUnit, convUnit, value);
        }
        return convert;
    }

    protected String strResult(double val, boolean rounded){
        if (rounded){
            val = Math.round(val*100.00)/100.00;
        }
        DecimalFormat s = new DecimalFormat("#.#####");
        return s.format(val);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
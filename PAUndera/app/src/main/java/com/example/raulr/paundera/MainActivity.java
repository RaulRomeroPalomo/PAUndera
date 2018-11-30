package com.example.raulr.paundera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button calcular;
    private TextView resultado;
    private Spinner spinnerModG, spinnerMod1, spinnerMod2, spinnerMod3, spinnerMod4, spinnerRamas, spinnerGrados;
    private EditText notaBach, notaComent, notaIdioma, notaHistoria, notaModG, notaMod1, notaMod2, notaMod3, notaMod4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        Button calcular = (Button) findViewById(R.id.calcular);

        notaBach = (EditText) findViewById(R.id.notaBach);
        notaComent = (EditText) findViewById(R.id.notaComent);
        notaIdioma = (EditText) findViewById(R.id.notaLang);
        notaHistoria = (EditText) findViewById(R.id.notaHist);
        notaModG = (EditText) findViewById(R.id.notaModG);
        notaMod1 = (EditText) findViewById(R.id.notaMod1);
        notaMod2 = (EditText) findViewById(R.id.notaMod2);
        notaMod3 = (EditText) findViewById(R.id.notaMod3);
        notaMod4 = (EditText) findViewById(R.id.notaMod4);
        resultado = (TextView) findViewById(R.id.numResultado);

        notaBach.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(2, 2), new InputFilterMinMax(0, 10)});
        notaComent.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(2, 2), new InputFilterMinMax(0, 10)});
        notaIdioma.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(2, 2), new InputFilterMinMax(0, 10)});
        notaHistoria.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(2, 2), new InputFilterMinMax(0, 10)});
        notaModG.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(2, 2), new InputFilterMinMax(0, 10)});
        notaMod1.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(2, 2), new InputFilterMinMax(0, 10)});
        notaMod2.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(2, 2), new InputFilterMinMax(0, 10)});
        notaMod3.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(2, 2), new InputFilterMinMax(0, 10)});
        notaMod4.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(2, 2), new InputFilterMinMax(0, 10)});


        spinnerModG = (Spinner) findViewById(R.id.spinnerModG);
        spinnerMod1 = (Spinner) findViewById(R.id.spinnerMod1);
        spinnerMod2 = (Spinner) findViewById(R.id.spinnerMod2);
        spinnerMod3 = (Spinner) findViewById(R.id.spinnerMod3);
        spinnerMod4 = (Spinner) findViewById(R.id.spinnerMod4);
        spinnerRamas = (Spinner) findViewById(R.id.spinnerRamas);
        spinnerGrados = (Spinner) findViewById(R.id.spinnerGrados);

        calcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String notaBachAux = notaBach.getText().toString();
        String notaComentAux = notaComent.getText().toString();
        String notaIdiomaAux = notaIdioma.getText().toString();
        String notaHistoriaAux = notaHistoria.getText().toString();
        String notaModGAux = notaModG.getText().toString();
        String notaMod1Aux = notaMod1.getText().toString();
        String notaMod2Aux = notaMod2.getText().toString();
        String notaMod3Aux = notaMod3.getText().toString();
        String notaMod4Aux = notaMod4.getText().toString();

        Double dnotaBachAux = Double.parseDouble(notaBachAux);
        Double dnotaComentAux = Double.parseDouble(notaComentAux);
        Double dnotaIdiomaAux = Double.parseDouble(notaIdiomaAux);
        Double dnotaHistoriaAux = Double.parseDouble(notaHistoriaAux);

        Double dnotaModGAux = Double.parseDouble(notaModGAux);
        Double dnotaMod1Aux = Double.parseDouble(notaMod1Aux);
        Double dnotaMod2Aux = Double.parseDouble(notaMod2Aux);
        Double dnotaMod3Aux = Double.parseDouble(notaMod3Aux);
        Double dnotaMod4Aux = Double.parseDouble(notaMod4Aux);

        int spinnerModGAux = spinnerModG.getSelectedItemPosition();
        int spinnerMod1Aux = spinnerMod1.getSelectedItemPosition();
        int spinnerMod2Aux = spinnerMod2.getSelectedItemPosition();
        int spinnerMod3Aux = spinnerMod3.getSelectedItemPosition();
        int spinnerMod4Aux = spinnerMod4.getSelectedItemPosition();
        String spinnerRamasAux = spinnerRamas.getSelectedItem().toString();
        int spinnerGradosAux = spinnerGrados.getSelectedItemPosition();

        String[] gradosCiencias = getResources().getStringArray(R.array.spinnerGradosCiencias);
        String[] asigCiencias = getResources().getStringArray(R.array.spinnerAsigCiencias);

        double notaFGeneral = (Double.parseDouble(notaComentAux) + Double.parseDouble(notaHistoriaAux) + Double.parseDouble(notaIdiomaAux) + dnotaModGAux) / 4;
        double notaFGexp = 0.6 * Double.parseDouble(notaBachAux) + 0.4 * notaFGeneral;

        DecimalFormat df = new DecimalFormat("#.###");


        if (notaFGeneral < 4) {
            resultado.setText("Fase General suspensa con un " + String.valueOf(notaFGeneral));
        } else {
            if (notaFGexp < 5) {
                resultado.setText("Fase Principal suspensa con un " + String.valueOf(notaFGexp));
            } else {

                double mod1PP = dnotaMod1Aux * pPonderacion(spinnerGradosAux, spinnerMod1Aux);
                double mod2PP = dnotaMod2Aux * pPonderacion(spinnerGradosAux, spinnerMod2Aux);
                double mod3PP = dnotaMod3Aux * pPonderacion(spinnerGradosAux, spinnerMod3Aux);
                double mod4PP = dnotaMod4Aux * pPonderacion(spinnerGradosAux, spinnerMod4Aux);

                List<Double> notasEsp = new ArrayList<Double>();

                if(mod1PP>=5){
                    notasEsp.add(mod1PP);
                }
                if(mod2PP>=5){
                    notasEsp.add(mod2PP);
                }
                if(mod3PP>=5){
                    notasEsp.add(mod3PP);
                }
                if(mod4PP>=5){
                    notasEsp.add(mod4PP);
                }
                Collections.sort(notasEsp);
                Collections.reverse(notasEsp);

                if (dnotaModGAux < 5) {

                    if(notasEsp.size() >= 2){
                        Double notaFinal = 0.6 * dnotaBachAux + 0.4 * notaFGeneral + notasEsp.get(0) + notasEsp.get(1);

                        String twoDigitNum = df.format(notaFinal);
                        resultado.setText("Tu nota sería un " + String.valueOf((notaFinal)));
                    }
                    if(notasEsp.size() == 1){
                        Double notaFinal = 0.6 * dnotaBachAux + 0.4 * notaFGeneral + notasEsp.get(0);

                        String twoDigitNum = df.format(notaFinal);
                        resultado.setText("Tu nota sería un " + String.valueOf((notaFinal)));
                    }
                    if(notasEsp.size() == 0){
                        Double notaFinal = 0.6 * dnotaBachAux + 0.4 * notaFGeneral;

                        String twoDigitNum = df.format(notaFinal);
                        resultado.setText("Tu nota sería un " + String.valueOf((notaFinal)));
                    }

                } else if (notaFGeneral >= 5) {

                    if (!Arrays.asList(asigCiencias).contains(spinnerModGAux)) {
                        if(notasEsp.size() >= 2){
                            Double notaFinal = 0.6 * dnotaBachAux + 0.4 * notaFGeneral + notasEsp.get(0) + notasEsp.get(1);

                            String twoDigitNum = df.format(notaFinal);
                            resultado.setText("Tu nota sería un " + String.valueOf((notaFinal)));
                        }
                        if(notasEsp.size() == 1){
                            Double notaFinal = 0.6 * dnotaBachAux + 0.4 * notaFGeneral + notasEsp.get(0);

                            String twoDigitNum = df.format(notaFinal);
                            resultado.setText("Tu nota sería un " + String.valueOf((notaFinal)));
                        }
                        if(notasEsp.size() == 0){
                            Double notaFinal = 0.6 * dnotaBachAux + 0.4 * notaFGeneral;

                            String twoDigitNum = df.format(notaFinal);
                            resultado.setText("Tu nota sería un " + String.valueOf((notaFinal)));
                        }
                    }
                    else {
                        if(notasEsp.size() >= 2){

                            double notaFGeneralAux1 = 0;
                            double notaFGeneralAux2 = 0;

                            if(mod1PP == notasEsp.get(0)) {
                                notaFGeneralAux1 = dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod1Aux / 4;
                            }
                            else if(mod1PP == notasEsp.get(1)) {
                                notaFGeneralAux2 = dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod1Aux / 4;
                            }


                            if(mod2PP == notasEsp.get(0)) {
                                notaFGeneralAux1 = dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod2Aux / 4;
                            }
                            else if(mod2PP == notasEsp.get(1)) {
                                notaFGeneralAux2 = dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod2Aux / 4;
                            }


                            if(mod3PP == notasEsp.get(0)) {
                                notaFGeneralAux1 = dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod3Aux / 4;
                            }
                            else if(mod3PP == notasEsp.get(1)) {
                                notaFGeneralAux2 = dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod3Aux / 4;
                            }


                            if(mod4PP == notasEsp.get(0)) {
                                notaFGeneralAux1 = dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod4Aux / 4;
                            }
                            else if(mod4PP == notasEsp.get(1)) {
                                notaFGeneralAux2 = dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod4Aux / 4;
                            }


                            double modGPP = dnotaModGAux * pPonderacion(spinnerGradosAux, spinnerModGAux);

                            Double notaFinal = 0.6 * dnotaBachAux + 0.4 * notaFGeneral + notasEsp.get(0) + notasEsp.get(1);
                            Double notaFinal1 = 0.6 * dnotaBachAux + 0.4 * notaFGeneralAux1 + modGPP + notasEsp.get(1);
                            Double notaFinal2 = 0.6 * dnotaBachAux + 0.4 * notaFGeneralAux2 + notasEsp.get(0) + modGPP;

                            if(notaFinal >= notaFinal1 && notaFinal >= notaFinal2){
                                String twoDigitNum = df.format(notaFinal);
                                resultado.setText("Tu nota sería un " + String.valueOf((notaFinal)));
                            }
                            if(notaFinal1 >= notaFinal && notaFinal >= notaFinal2){
                                String twoDigitNum = df.format(notaFinal1);
                                resultado.setText("Tu nota sería un " + String.valueOf((notaFinal2)));
                            }
                            if(notaFinal2 >= notaFinal1 && notaFinal2 >= notaFinal){
                                String twoDigitNum = df.format(notaFinal2);
                                resultado.setText("Tu nota sería un " + String.valueOf((notaFinal2)));
                            }
                        }
                        if(notasEsp.size() == 1){

                            double notaFGeneralAux1 = 0;

                            if(mod1PP == notasEsp.get(0)) {
                                notaFGeneralAux1 = dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod1Aux / 4;
                            }

                            if(mod2PP == notasEsp.get(0)) {
                                notaFGeneralAux1 = dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod2Aux / 4;
                            }

                            if(mod3PP == notasEsp.get(0)) {
                                notaFGeneralAux1 = dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod3Aux / 4;
                            }

                            if(mod4PP == notasEsp.get(0)) {
                                notaFGeneralAux1 = dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod4Aux / 4;
                            }

                            double modGPP = dnotaModGAux * pPonderacion(spinnerGradosAux, spinnerModGAux);

                            Double notaFinal = 0.6 * dnotaBachAux + 0.4 * notaFGeneral + notasEsp.get(0);
                            Double notaFinal1 = 0.6 * dnotaBachAux + 0.4 * notaFGeneralAux1 + modGPP;

                            if(notaFinal >= notaFinal1){
                                String twoDigitNum = df.format(notaFinal);
                                resultado.setText("Tu nota sería un " + String.valueOf((notaFinal)));
                            }else{
                                String twoDigitNum = df.format(notaFinal1);
                                resultado.setText("Tu nota sería un " + String.valueOf((notaFinal1)));
                            }

                        }
                        if(notasEsp.size() == 0){
                            Double notaFinal = 0.6 * Double.parseDouble(notaBachAux) + 0.4 * notaFGeneral;

                            String twoDigitNum = df.format(notaFinal);
                            resultado.setText("Tu nota sería un " + String.valueOf((notaFinal)));
                        }
                    }
                }
            }
        }
    }
    public double pPonderacion(int x, int y) {

        Double[][] tablaPondCiencias = {{0.2, 0.2, 0.0, 0.0, 0.0, 0.1, 0.2, 0.2, 0.2, 0.0, 0.2, 0.1},
                {0.2, 0.2, 0.0, 0.0, 0.0, 0.1, 0.2, 0.2, 0.2, 0.0, 0.2, 0.1},
                {0.2, 0.2, 0.0, 0.0, 0.0, 0.1, 0.2, 0.2, 0.2, 0.0, 0.2, 0.1}};

        return tablaPondCiencias[x][y];
    }
}


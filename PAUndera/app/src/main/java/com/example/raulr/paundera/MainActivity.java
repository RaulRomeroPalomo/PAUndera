package com.example.raulr.paundera;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button calcular;
    private TextView resultado;
    private EditText notaBach, notaComent, notaIdioma, notaHistoria, notaModG, notaMod1, notaMod2, notaMod3, notaMod4;
    private SearchableSpinner grados, modG, mod1, mod2, mod3, mod4;

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


        modG = (SearchableSpinner) findViewById(R.id.modG);
        mod1 = (SearchableSpinner) findViewById(R.id.mod1);
        mod2 = (SearchableSpinner) findViewById(R.id.mod2);
        mod3 = (SearchableSpinner) findViewById(R.id.mod3);
        mod4 = (SearchableSpinner) findViewById(R.id.mod4);
        grados = (SearchableSpinner) findViewById(R.id.grados);

        modG.setTitle("Selecciona un asignatura");
        modG.setPositiveButton("OK");
        mod1.setTitle("Selecciona un asignatura");
        mod1.setPositiveButton("OK");
        mod2.setTitle("Selecciona un asignatura");
        mod2.setPositiveButton("OK");
        mod3.setTitle("Selecciona un asignatura");
        mod3.setPositiveButton("OK");
        mod4.setTitle("Selecciona un asignatura");
        mod4.setPositiveButton("OK");

        grados.setTitle("Selecciona un grado");
        grados.setPositiveButton("OK");

        calcular.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {

        checkCampos(notaBach, notaComent, notaHistoria, notaIdioma, notaModG, notaMod1, notaMod2, notaMod3, notaMod4);

        String[] gradosCiencias = getResources().getStringArray(R.array.spinnerGradosCiencias);

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

        int nModGAux = modG.getSelectedItemPosition();
        int nMod1Aux = mod1.getSelectedItemPosition();
        int nMod2Aux = mod2.getSelectedItemPosition();
        int nMod3Aux = mod3.getSelectedItemPosition();
        int nMod4Aux = mod4.getSelectedItemPosition();

        String[] asigCiencias = getResources().getStringArray(R.array.spinnerAsigCiencias);
        String[] asigModG = getResources().getStringArray(R.array.spinnerModG);

        String modGAux = Arrays.asList(asigModG).get(nModGAux);
        String mod1Aux = Arrays.asList(asigCiencias).get(nMod1Aux);
        String mod2Aux = Arrays.asList(asigCiencias).get(nMod2Aux);
        String mod3Aux = Arrays.asList(asigCiencias).get(nMod3Aux);
        String mod4Aux = Arrays.asList(asigCiencias).get(nMod4Aux);
        Log.e("1", modGAux);
        Log.e("2", mod1Aux);
        Log.e("3", mod2Aux);
        Log.e("4", mod3Aux);
        Log.e("5", mod4Aux);
        int gradoIndex = grados.getSelectedItemPosition();
        String grado = Arrays.asList(gradosCiencias).get(gradoIndex);

        double notaFGeneral = (dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaModGAux) / 4;
        double notaFGexp = 0.6 * dnotaBachAux + 0.4 * notaFGeneral;

        DecimalFormat df = new DecimalFormat("#.###");


        if(!checkSpinners(modGAux, mod1Aux, mod2Aux, mod3Aux, mod4Aux)) {
            Toast.makeText(this, "1 o más asignaturas están repetidas", Toast.LENGTH_SHORT).show();
        }
        else{
            if (notaFGeneral < 4) {
                resultado.setText("Fase General suspensa con un " + String.valueOf(notaFGeneral));
            } else {
                if (notaFGexp < 5) {
                    resultado.setText("Fase Principal suspensa con un " + String.valueOf(notaFGexp));
                } else {

                    double mod1PP = dnotaMod1Aux * pPonderacion(gradoIndex, nMod1Aux);
                    double mod2PP = dnotaMod2Aux * pPonderacion(gradoIndex, nMod2Aux);
                    double mod3PP = dnotaMod3Aux * pPonderacion(gradoIndex, nMod3Aux);
                    double mod4PP = dnotaMod4Aux * pPonderacion(gradoIndex, nMod4Aux);

                    List<Double> notasEsp = new ArrayList<>();

                    if (dnotaMod1Aux >= 5) {
                        notasEsp.add(mod1PP);
                    }
                    if (dnotaMod2Aux >= 5) {
                        notasEsp.add(mod2PP);
                    }
                    if (dnotaMod3Aux >= 5) {
                        notasEsp.add(mod3PP);
                    }
                    if (dnotaMod4Aux >= 5) {
                        notasEsp.add(mod4PP);
                    }
                    Collections.sort(notasEsp);
                    Collections.reverse(notasEsp);

                    if (dnotaModGAux < 5) {

                        if (notasEsp.size() >= 2) {
                            Double notaFinal = 0.6 * dnotaBachAux + 0.4 * notaFGeneral + notasEsp.get(0) + notasEsp.get(1);

                            String twoDigitNum = df.format(notaFinal);
                            resultado.setText("1Tu nota sería un " + String.valueOf((notaFinal)));
                        }
                        if (notasEsp.size() == 1) {
                            Double notaFinal = 0.6 * dnotaBachAux + 0.4 * notaFGeneral + notasEsp.get(0);

                            String twoDigitNum = df.format(notaFinal);
                            resultado.setText("2Tu nota sería un " + String.valueOf((notaFinal)));
                        }
                        if (notasEsp.size() == 0) {
                            Double notaFinal = 0.6 * dnotaBachAux + 0.4 * notaFGeneral;

                            String twoDigitNum = df.format(notaFinal);
                            resultado.setText("3Tu nota sería un " + String.valueOf((notaFinal)));
                        }

                    } else if (notaFGeneral >= 5) {

                        if (!Arrays.asList(asigCiencias).contains(modGAux)) {
                            if (notasEsp.size() >= 2) {
                                Double notaFinal = 0.6 * dnotaBachAux + 0.4 * notaFGeneral + notasEsp.get(0) + notasEsp.get(1);

                                String twoDigitNum = df.format(notaFinal);
                                resultado.setText("4Tu nota sería un " + String.valueOf((notaFinal)));
                            }
                            if (notasEsp.size() == 1) {
                                Double notaFinal = 0.6 * dnotaBachAux + 0.4 * notaFGeneral + notasEsp.get(0);

                                String twoDigitNum = df.format(notaFinal);
                                resultado.setText("5Tu nota sería un " + String.valueOf((notaFinal)));
                            }
                            if (notasEsp.size() == 0) {
                                Double notaFinal = 0.6 * dnotaBachAux + 0.4 * notaFGeneral;

                                String twoDigitNum = df.format(notaFinal);
                                resultado.setText("6Tu nota sería un " + String.valueOf((notaFinal)));
                            }
                        } else {
                            if (notasEsp.size() >= 2) {

                                double notaFGeneralAux1 = 0;
                                double notaFGeneralAux2 = 0;

                                if (mod1PP == notasEsp.get(0)) {
                                    notaFGeneralAux1 = (dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod1Aux) / 4;
                                } else if (mod1PP == notasEsp.get(1)) {
                                    notaFGeneralAux2 = (dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod1Aux) / 4;
                                }


                                if (mod2PP == notasEsp.get(0)) {
                                    notaFGeneralAux1 = (dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod2Aux) / 4;
                                } else if (mod2PP == notasEsp.get(1)) {
                                    notaFGeneralAux2 = (dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod2Aux) / 4;
                                }


                                if (mod3PP == notasEsp.get(0)) {
                                    notaFGeneralAux1 = (dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod3Aux) / 4;
                                } else if (mod3PP == notasEsp.get(1)) {
                                    notaFGeneralAux2 = (dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod3Aux) / 4;
                                }


                                if (mod4PP == notasEsp.get(0)) {
                                    notaFGeneralAux1 = (dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod4Aux) / 4;
                                } else if (mod4PP == notasEsp.get(1)) {
                                    notaFGeneralAux2 = (dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod4Aux) / 4;
                                }

                                double modGPP = dnotaModGAux * pPonderacion(gradoIndex, Arrays.asList(asigCiencias).indexOf(modGAux));


                                Double notaFinal = 0.6 * dnotaBachAux + 0.4 * notaFGeneral + notasEsp.get(0) + notasEsp.get(1);
                                Double notaFinal1 = 0.6 * dnotaBachAux + 0.4 * notaFGeneralAux1 + modGPP + notasEsp.get(1);
                                Double notaFinal2 = 0.6 * dnotaBachAux + 0.4 * notaFGeneralAux2 + notasEsp.get(0) + modGPP;

                                if (notaFinal >= notaFinal1 && notaFinal >= notaFinal2) {
                                    String twoDigitNum = df.format(notaFinal);
                                    resultado.setText("7Tu nota sería un " + twoDigitNum);
                                }
                                if (notaFinal1 >= notaFinal && notaFinal >= notaFinal2) {
                                    String twoDigitNum = df.format(notaFinal1);
                                    resultado.setText("8Tu nota sería un " + twoDigitNum);
                                }
                                if (notaFinal2 >= notaFinal1 && notaFinal2 >= notaFinal) {
                                    String twoDigitNum = df.format(notaFinal2);
                                    resultado.setText("9Tu nota sería un " + twoDigitNum);
                                }
                            }
                            if (notasEsp.size() == 1) {

                                double notaFGeneralAux1 = 0;

                                if (mod1PP == notasEsp.get(0)) {
                                    notaFGeneralAux1 = (dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod1Aux) / 4;
                                }

                                if (mod2PP == notasEsp.get(0)) {
                                    notaFGeneralAux1 = (dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod2Aux) / 4;
                                }

                                if (mod3PP == notasEsp.get(0)) {
                                    notaFGeneralAux1 = (dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod3Aux) / 4;
                                }

                                if (mod4PP == notasEsp.get(0)) {
                                    notaFGeneralAux1 = (dnotaComentAux + dnotaHistoriaAux + dnotaIdiomaAux + dnotaMod4Aux) / 4;
                                }

                                double modGPP = dnotaModGAux * pPonderacion(gradoIndex, Arrays.asList(asigCiencias).indexOf(modGAux));

                                Double notaFinal = 0.6 * dnotaBachAux + 0.4 * notaFGeneral + notasEsp.get(0) + modGPP;

                                String twoDigitNum = df.format(notaFinal);
                                resultado.setText("11Tu nota sería un " + String.valueOf((notaFinal)));

                            }
                            if (notasEsp.size() == 0) {

                                double modGPP = dnotaModGAux * pPonderacion(gradoIndex, Arrays.asList(asigCiencias).indexOf(modGAux));
                                Double notaFinal = 0.6 * Double.parseDouble(notaBachAux) + 0.4 * notaFGeneral + modGPP;

                                String twoDigitNum = df.format(notaFinal);
                                resultado.setText("12Tu nota sería un " + String.valueOf((notaFinal)));
                            }
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
    public boolean checkSpinners(String x, String y, String z, String t, String w){
        boolean res = true;
        if(x.equals(y) || x.equals(z) || x.equals(t) || x.equals(w) || y.equals(z) || y.equals(t) || y.equals(w) || z.equals(t) || z.equals(w) || t.equals(w)){
            res = false;
        }
        return res;
    }
    public void checkCampos(EditText a, EditText b, EditText c, EditText d, EditText e, EditText f, EditText g, EditText h, EditText i){
        List<EditText> campos = Arrays.asList(a, b, c, d, e, f, g, h, i);
        for(EditText campo: campos){
            if(campo.getText().toString().matches("")){
                campo.setText("0");
            }
        }
    }
}


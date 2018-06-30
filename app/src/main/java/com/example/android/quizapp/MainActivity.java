package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//initialize Answers
    private RadioGroup question1Radio;
    private RadioGroup question2Radio;
    private RadioGroup question3Radio;
    private RadioGroup question4Radio;
    private RadioGroup question5Radio;
    private RadioGroup question6Radio;
    private RadioGroup question9Radio;

    private CheckBox chinaChk;
    private CheckBox UsaChk;
    private CheckBox geogeriaChk;
    private CheckBox tunisaChk;

    private EditText vanuatuText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //Method to display result
    public void toastResult(int result) {
        String message = result + " out of 10. ";

        if (result == 0) {
            message += "Poor luck.";
        } else if (result <= 5) {
            message += "You could do better.";
        } else if (result <= 7) {
            message += "Nice.";
        } else if (result <= 9) {
            message += "Great!";
        } else if (result == 10) {
            message += "Absolutely awesome!";
        }

        Toast reportResult = Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT);
        reportResult.show();

    }

    public void submit(View view) {


        question1Radio = (RadioGroup) findViewById(R.id.question1_button_group);
        int answer1Id = question1Radio.getCheckedRadioButtonId();

        question2Radio = (RadioGroup) findViewById(R.id.question2_button_group);
        int answer2Id = question2Radio.getCheckedRadioButtonId();

        question3Radio = (RadioGroup) findViewById(R.id.question3_button_group);
        int answer3Id = question3Radio.getCheckedRadioButtonId();

        question4Radio = (RadioGroup) findViewById(R.id.question4_button_group);
        int answer4Id = question4Radio.getCheckedRadioButtonId();

        question5Radio = (RadioGroup) findViewById(R.id.question5_button_group);
        int answer5Id = question5Radio.getCheckedRadioButtonId();

        question6Radio = (RadioGroup) findViewById(R.id.question6_button_group);
        int answer6Id = question6Radio.getCheckedRadioButtonId();

        question9Radio = (RadioGroup) findViewById(R.id.question9_button_group);
        int answer9Id = question9Radio.getCheckedRadioButtonId();


        chinaChk = (CheckBox) findViewById(R.id.china_checkbox);
        boolean haschina = chinaChk.isChecked();

        tunisaChk = (CheckBox) findViewById(R.id.tunisia_checkbox);


        UsaChk = (CheckBox) findViewById(R.id.usa_checkbox);

        geogeriaChk = (CheckBox) findViewById(R.id.georgia_checkbox);
        boolean hasgeogeria = geogeriaChk.isChecked();

        vanuatuText = (EditText) findViewById(R.id.vanuatu_text);
        String answer8Id = vanuatuText.getText().toString();


        int result = q1Score(answer1Id) + q2Score(answer2Id) + q3Score(answer3Id) + q4Score(answer4Id)+
                q5Score(answer5Id) + q6Score(answer6Id) + q7Score(haschina, hasgeogeria) +
                q8Score(answer8Id) + q9Score(answer9Id);
        toastResult(result);
        Log.v("result", "result");



    }

    public void reset(View view) {

        question1Radio = (RadioGroup) findViewById(R.id.question1_button_group);
        question1Radio.clearCheck();

        question2Radio = (RadioGroup) findViewById(R.id.question2_button_group);
        question2Radio.clearCheck();

        question3Radio = (RadioGroup) findViewById(R.id.question3_button_group);
        question3Radio.clearCheck();

        question4Radio = (RadioGroup) findViewById(R.id.question4_button_group);
        question4Radio.clearCheck();

        question5Radio = (RadioGroup) findViewById(R.id.question5_button_group);
        question5Radio.clearCheck();

        question6Radio = (RadioGroup) findViewById(R.id.question6_button_group);
        question6Radio.clearCheck();

        question9Radio = (RadioGroup) findViewById(R.id.question9_button_group);
        question9Radio.clearCheck();

        chinaChk = (CheckBox) findViewById(R.id.china_checkbox);
        chinaChk.setChecked(false);

        tunisaChk = (CheckBox) findViewById(R.id.tunisia_checkbox);
        tunisaChk.setChecked(false);

        UsaChk = (CheckBox) findViewById(R.id.usa_checkbox);
        UsaChk.setChecked(false);

        geogeriaChk = (CheckBox) findViewById(R.id.georgia_checkbox);
        geogeriaChk.setChecked(false);

        vanuatuText = (EditText) findViewById(R.id.vanuatu_text);
        vanuatuText.setText("");


    }

    public void showAswer(View view){
        question1Radio = (RadioGroup) findViewById(R.id.question1_button_group);
        question1Radio.check(R.id.radio_Abuja);

        question2Radio = (RadioGroup) findViewById(R.id.question2_button_group);
        question2Radio.check(R.id.radio_Tbilisi);

        question3Radio = (RadioGroup) findViewById(R.id.question3_button_group);
        question3Radio.check(R.id.andorra_radio);

        question4Radio = (RadioGroup) findViewById(R.id.question4_button_group);
        question4Radio.check(R.id.madrid_radio);

        question5Radio = (RadioGroup) findViewById(R.id.question5_button_group);
        question5Radio.check(R.id.vaduz_radio);

        question6Radio = (RadioGroup) findViewById(R.id.question6_button_group);
        question6Radio.check(R.id.freeTown_radio);

        question9Radio = (RadioGroup) findViewById(R.id.question9_button_group);
        question9Radio.check(R.id.true_radio);

        chinaChk = (CheckBox) findViewById(R.id.china_checkbox);
        chinaChk.setChecked(true);

        tunisaChk = (CheckBox) findViewById(R.id.tunisia_checkbox);
        tunisaChk.setChecked(false);

        UsaChk = (CheckBox) findViewById(R.id.usa_checkbox);
        UsaChk.setChecked(false);

        geogeriaChk = (CheckBox) findViewById(R.id.georgia_checkbox);
        geogeriaChk.setChecked(true);

        vanuatuText = (EditText) findViewById(R.id.vanuatu_text);
        vanuatuText.setText("Port Vila");

    }

    /*Method for getting score of question 1
     * @param answer1 is the Id of answer radiobutton
     */
    private int q1Score(int answer1) {
        int score1;

        if (answer1 == R.id.radio_Abuja) {
            score1 = 1;
        } else {
            score1 = 0;
        }

        return score1;
    }

    /*Method for getting score of question 2
     * @param answer2 is the Id of answer radiobutton
     */
    private int q2Score(int answer2) {
        int score2;

        if (answer2 == R.id.radio_Tbilisi) {
            score2 = 1;
        } else {
            score2 = 0;
        }
        return score2;
    }

    /*Method for getting score of question 3
     * @param answer3 is the Id of answer radiobutton
     */
    private int q3Score(int answer3) {
        int score3;

        if (answer3 == R.id.andorra_radio) {
            score3 = 1;
        } else {
            score3 = 0;
        }
        return score3;
    }

    /*Method for getting score of question 4
     * @param answer4 is the Id of answer radiobutton
     */

    private int q4Score(int answer4) {
        int score4;

        if (answer4 == R.id.madrid_radio) {
            score4 = 1;
        } else {
            score4 = 0;
        }
        return score4;
    }

    /*Method for getting score of question 5
     * @param answer5 is the Id of answer radiobutton
     */

    private int q5Score(int answer5) {
        int score5;

        if (answer5 == R.id.vaduz_radio) {
            score5 = 1;
        } else {
            score5 = 0;
        }
        return score5;
    }

    /*Method for getting score of question 6
     * @param answer6 is the Id of answer radiobutton
     */

    private int q6Score(int answer6) {
        int score6;

        if (answer6 == R.id.freeTown_radio) {
            score6 = 1;
        } else {
            score6 = 0;
        }
        return score6;
    }

    /*Method for getting score of question 7
     * @param haschina check the state of China checkbox
     * @param hasgeogeria checks the state of geogeria checkbox
     */
    private int q7Score(boolean haschina, boolean hasgeogeria) {

        int score7=0;

        if (haschina && hasgeogeria) {
            score7 +=2;

        } else if (haschina) {
            score7 = 1;
        } else if (hasgeogeria) {
            score7 = 1;
        } else {
            score7 = 0;
        }


        return score7;
    }

    /*Method for getting score of question 8
     * @param answer8 is the String input by the user
     */
    private int q8Score(String answer8) {
        int score8;
        String answer = "Port Vila";

        if (answer8.equals(answer))
        {
            score8 = 1;
        } else {
            score8 = 0;
        }
        return score8;

    }

    /*Method for getting score of question 9
     * @param answer9 is the Id of answer radiobutton
     */
    private int q9Score(int answer9) {
        int score9;

        if (answer9 == R.id.true_radio) {
            score9 = 1;
        } else {
            score9 = 0;
        }
        return score9;
    }
}

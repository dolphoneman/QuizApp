package com.encounterfitness.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static android.view.Gravity.BOTTOM;
import static android.view.Gravity.CENTER;
import static android.view.Gravity.END;
import static android.view.Gravity.START;
import static android.view.Gravity.TOP;

public class MainActivity extends AppCompatActivity {

    float score;
    float total;

    EditText nameIsEditText;

    RadioButton question1RadioButton1;
    RadioButton question1RadioButton2;
    RadioButton question1RadioButton3;
    RadioButton question1RadioButton4;

    CheckBox question2CheckBox1;
    CheckBox question2CheckBox2;
    CheckBox question2CheckBox3;
    CheckBox question2CheckBox4;
    CheckBox question2CheckBox5;
    CheckBox question2CheckBox6;

    RadioButton question3RadioButton1;
    RadioButton question3RadioButton2;

    EditText answer4EditText;

    RadioButton question5RadioButton1;
    RadioButton question5RadioButton2;
    RadioButton question5RadioButton3;
    RadioButton question5RadioButton4;

    CheckBox question6CheckBox1;
    CheckBox question6CheckBox2;
    CheckBox question6CheckBox3;
    CheckBox question6CheckBox4;
    CheckBox question6CheckBox5;

    EditText answer7EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameIsEditText = findViewById(R.id.nameField);

        question1RadioButton1 = findViewById(R.id.question1radio1);
        question1RadioButton2 = findViewById(R.id.question1radio2);
        question1RadioButton3 = findViewById(R.id.question1radio3);
        question1RadioButton4 = findViewById(R.id.question1radio4);

        question2CheckBox1 = findViewById(R.id.question2check1);
        question2CheckBox2 = findViewById(R.id.question2check2);
        question2CheckBox3 = findViewById(R.id.question2check3);
        question2CheckBox4 = findViewById(R.id.question2check4);
        question2CheckBox5 = findViewById(R.id.question2check5);
        question2CheckBox6 = findViewById(R.id.question2check6);

        question3RadioButton1 = findViewById(R.id.question3true);
        question3RadioButton2 = findViewById(R.id.question3false);

        answer4EditText = findViewById(R.id.question4answer);

        question5RadioButton1 = findViewById(R.id.question5radio1);
        question5RadioButton2 = findViewById(R.id.question5radio2);
        question5RadioButton3 = findViewById(R.id.question5radio3);
        question5RadioButton4 = findViewById(R.id.question5radio4);

        question6CheckBox1 = findViewById(R.id.question6check1);
        question6CheckBox2 = findViewById(R.id.question6check2);
        question6CheckBox3 = findViewById(R.id.question6check3);
        question6CheckBox4 = findViewById(R.id.question6check4);
        question6CheckBox5 = findViewById(R.id.question6check5);

        answer7EditText = findViewById(R.id.question7answer);
    }

    /**
     * Provide results after the submit button is clicked
     */
    public void submitAnswers(View view) {

        score = 0;

        /**
         * Get the user name
         */
        String nameIs = getName();

        /**
         * Check question 1
         */
        question1Check1();
        question1Check2();
        question1Check3();
        question1Check4();

        /**
         * Make sure question 1 was not left blank notify with a Toast if it was
         */
        if (!question1Check1() && !question1Check2() && !question1Check3() && !question1Check4()) {

            int questionNumber = 1;

            forgotAnswer(nameIs, questionNumber, TOP, START);
        }

        /**
         * Check if question 1 is correct and update score if needed
         */
        else if (question1Check2()) {
            score = score + 1;
        }

        /**
         * Check question 2
         */
        question2Check1();
        question2Check2();
        question2Check3();
        question2Check4();
        question2Check5();
        question2Check6();

        /**
         * Make sure question 2 was not left blank notify with a Toast if it was
         */
        if (!question2Check1() && !question2Check2() && !question2Check3() && !question2Check4() && !question2Check5() && !question2Check6()) {

            int questionNumber = 2;

            forgotAnswer(nameIs, questionNumber, CENTER, START);
        }

        /**
         * Check if question 2 is correct and update score if needed
         */
        else if (question2Check1() && question2Check2() && question2Check4() && question2Check6() && !question2Check3() && !question2Check5()) {
            score = score + 1;
        }

        /**
         * Check question 3
         */
        question3Check1();
        question3Check2();

        /**
         * Make sure question 3 was not left blank notify with a Toast if it was
         */
        if (!question3Check1() && !question3Check2()) {

            int questionNumber = 3;

            forgotAnswer(nameIs, questionNumber, BOTTOM, START);
        }

        /**
         * Check if question 3 is correct and update score if needed
         */
        else if (question3Check2()) {
            score = score + 1;
        }

        /**
         * Get text for question 4 answer
         */
        getAnswer4();

        /**
         * Make sure question 4 was not left blank notify with a Toast if it was
         */
        if (getAnswer4().toUpperCase().equals("")) {

            int questionNumber = 4;

            forgotAnswer(nameIs, questionNumber, TOP, END);
        }

        /**
         * Check if question 4 is correct and update score if needed
         */
        else if (getAnswer4().toUpperCase().equals("CPU")){
            score = score + 1;
        }

        /**
         * Check question 5
         */
        question5Check1();
        question5Check2();
        question5Check3();
        question5Check4();

        /**
         * Make sure question 5 was not left blank notify with a Toast if it was
         */
        if (!question5Check1() && !question5Check2() && !question5Check3() && !question5Check4()) {

            int questionNumber = 5;

            forgotAnswer(nameIs, questionNumber, CENTER, END);
        }

        /**
         * Check if question 5 is correct and update score if needed
         */
        else if (question5Check2()){
            score = score + 1;
        }

        /**
         * Check question 6
         */
        question6Check1();
        question6Check2();
        question6Check3();
        question6Check4();
        question6Check5();

        /**
         * Make sure question 6 was not left blank notify with a Toast if it was
         */
        if (!question6Check1() && !question6Check3() && !question6Check4() && !question6Check2() && !question6Check5()) {

            int questionNumber = 6;

            forgotAnswer(nameIs, questionNumber, BOTTOM, END);
        }

        /**
         * Check if question 6 is correct and update score if needed
         */
        else if (question6Check1() && question6Check3() && question6Check4() && !question6Check2() && !question6Check5()) {
            score = score + 1;
        }

        /**
         * Get text for question 7 answer
         */
        getAnswer7();

        /**
         * Make sure question 7 was not left blank notify with a Toast if it was
         */
        if (getAnswer7().toLowerCase().equals("")) {

            int questionNumber = 7;

            forgotAnswer(nameIs, questionNumber, TOP, END);
        }

        /**
         * Check if question 7 is correct and update score if needed
         */
        else if (getAnswer7().toLowerCase().equals("heat sink")) {
            score = score + 1;
        }

        /**
         * Get total and display for the final score
         */
        total = (score / 7) * 100;
        total = (int) total;

        /**
         * Toast for final score after clicking the submit button
         */
        Context context = MainActivity.this;
        CharSequence text = nameIs + " " + getString(R.string.score) + " " +total +"%"+". You had " + score + " answers correct.";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * Get the users name
     *
     */
    public String getName (){

        String whatIsName = nameIsEditText.getText().toString();
        return (whatIsName);
    }

    /**
     * Get logic for question 1 and pass to submitAnswers method
     */
    public boolean question1Check1() {

        boolean question1RadioButton1Checked = question1RadioButton1.isChecked();
        return (question1RadioButton1Checked);
    }

    public boolean question1Check2() {

        boolean question1RadioButton2Checked = question1RadioButton2.isChecked();
        return (question1RadioButton2Checked);
    }

    public boolean question1Check3() {

        boolean question1RadioButton3Checked = question1RadioButton3.isChecked();
        return (question1RadioButton3Checked);
    }

    public boolean question1Check4() {

        boolean question1RadioButton4Checked = question1RadioButton4.isChecked();
        return (question1RadioButton4Checked);
    }

    /**
     * Get Check box logic for question 2 and pass to submitAnswers method
     */
    public boolean question2Check1() {

        boolean question2CheckBox1Checked = question2CheckBox1.isChecked();
        return (question2CheckBox1Checked);
    }

    public boolean question2Check2() {

        boolean question2CheckBox2Checked = question2CheckBox2.isChecked();
        return (question2CheckBox2Checked);
    }

    public boolean question2Check3() {

        boolean question2CheckBox3Checked = question2CheckBox3.isChecked();
        return (question2CheckBox3Checked);
    }

    public boolean question2Check4() {

        boolean question2CheckBox4Checked = question2CheckBox4.isChecked();
        return (question2CheckBox4Checked);
    }

    public boolean question2Check5() {

        boolean question2CheckBox5Checked = question2CheckBox5.isChecked();
        return (question2CheckBox5Checked);
    }

    public boolean question2Check6() {

        boolean question2CheckBox6Checked = question2CheckBox6.isChecked();
        return (question2CheckBox6Checked);
    }

    /**
     * Get logic for question 3 and pass to submitAnswers method
     */
    public boolean question3Check1() {

        boolean question3RadioButton1Checked = question3RadioButton1.isChecked();
        return (question3RadioButton1Checked);
    }

    public boolean question3Check2() {

        boolean question3RadioButton2Checked = question3RadioButton2.isChecked();
        return (question3RadioButton2Checked);
    }

    /**
     * Grab text for answer 4 pass to submitAnswers method
     */
    public String getAnswer4 () {

        String whatIsAnswer4 = answer4EditText.getText().toString();
        return (whatIsAnswer4);
    }

    /**
     * Get logic for question 5 and pass to submitAnswers method
     */
    public boolean question5Check1() {

        boolean question5RadioButton1Checked = question5RadioButton1.isChecked();
        return (question5RadioButton1Checked);
    }

    public boolean question5Check2() {

        boolean question5RadioButton2Checked = question5RadioButton2.isChecked();
        return (question5RadioButton2Checked);
    }

    public boolean question5Check3() {

        boolean question5RadioButton3Checked = question5RadioButton3.isChecked();
        return (question5RadioButton3Checked);
    }

    public boolean question5Check4() {

        boolean question5RadioButton4Checked = question5RadioButton4.isChecked();
        return (question5RadioButton4Checked);
    }

    /**
     * Get Check box logic for question 6 and pass to submitAnswers method
     */
    public boolean question6Check1() {

        boolean question6CheckBox1Checked = question6CheckBox1.isChecked();
        return (question6CheckBox1Checked);
    }

    public boolean question6Check2() {

        boolean question6CheckBox2Checked = question6CheckBox2.isChecked();
        return (question6CheckBox2Checked);
    }

    public boolean question6Check3() {

        boolean question6CheckBox3Checked = question6CheckBox3.isChecked();
        return (question6CheckBox3Checked);
    }

    public boolean question6Check4() {

        boolean question6CheckBox4Checked = question6CheckBox4.isChecked();
        return (question6CheckBox4Checked);
    }

    public boolean question6Check5() {

        boolean question6CheckBox5Checked = question6CheckBox5.isChecked();
        return (question6CheckBox5Checked);
    }

    /**
     * Grab text for answer 7 pass to submitAnswers method
     */
    public String getAnswer7 () {

        String whatIsAnswer7 = answer7EditText.getText().toString();
        return (whatIsAnswer7);
    }

    /**
     * Function for a Toast if a question was not answered
     * @param nameIs User's name
     */
    public void forgotAnswer (String nameIs, int questionNumber, int positiony, int positionx) {
        Context context = MainActivity.this;
        CharSequence text = nameIs + " " + getString(R.string.forgotAnswer) + " " + questionNumber;
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(positiony| positionx, 0, 0);
        toast.show();
    }

    /**
     * Logic to reset answers when reset button is clicked
     */

    public void resetAnswers(View view) {
        score = 0;
        total = 0;

        nameIsEditText.setText("");

        question1RadioButton1.setChecked(false);
        question1RadioButton2.setChecked(false);
        question1RadioButton3.setChecked(false);
        question1RadioButton4.setChecked(false);

        question2CheckBox1.setChecked(false);
        question2CheckBox2.setChecked(false);
        question2CheckBox3.setChecked(false);
        question2CheckBox4.setChecked(false);
        question2CheckBox5.setChecked(false);
        question2CheckBox6.setChecked(false);

        question3RadioButton1.setChecked(false);
        question3RadioButton2.setChecked(false);

        answer4EditText.setText("");

        question5RadioButton1.setChecked(false);
        question5RadioButton2.setChecked(false);
        question5RadioButton3.setChecked(false);
        question5RadioButton4.setChecked(false);

        question6CheckBox1.setChecked(false);
        question6CheckBox2.setChecked(false);
        question6CheckBox3.setChecked(false);
        question6CheckBox4.setChecked(false);
        question6CheckBox5.setChecked(false);

        answer7EditText.setText("");
    }

}

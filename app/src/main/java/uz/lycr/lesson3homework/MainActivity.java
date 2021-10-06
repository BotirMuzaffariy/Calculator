package uz.lycr.lesson3homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNumber;
    private TextView tvLastNumber, tvMathCharacter;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnPoint, btnClear, btnPlusMinus, btnPercent, btnDivision, btnMultiplication, btnMinus, btnPlus, btnEquals, btnBackspace;

    private String character;
    private int arithmeticCharNumber = 0;
    private double number2, lastNumber;
    private boolean isNum1 = false, isNum2 = false;

    private final String CHARACTER_PLUS = "＋";
    private final String CHARACTER_MINUS = "－";
    private final String CHARACTER_PERCENT = "%";
    private final String CHARACTER_DIVISION = "÷";
    private final String CHARACTER_MULTIPLICATION = "×";
    private final int NUMBER_LIMIT = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findUI();

        btnBackspace.setOnClickListener(v -> {
            if (!etNumber.getText().toString().isEmpty() && !etNumber.getText().toString().startsWith("0")) {
                etNumber.getText().delete(etNumber.length() - 1, etNumber.length());
            }
        });
        btnClear.setOnClickListener(v -> setDefaultState());
        btnPlusMinus.setOnClickListener(v -> {
            String text = etNumber.getText().toString();
            if (text.length() > 0 && !text.startsWith("0")) {
                String newText = "";
                if (text.startsWith("-")) {
                    newText = text.substring(1);
                } else {
                    newText = "-" + text;
                }
                etNumber.setText(newText);
            }
        });
        btnPoint.setOnClickListener(v -> {
            if (etNumber.length() <= NUMBER_LIMIT) {
                String text = etNumber.getText().toString();
                if (!text.contains(".") && !text.equals("-")) {
                    etNumber.append(".");
                }
            }
        });

        btnDivision.setOnClickListener(v -> {
            String text = etNumber.getText().toString();
            if (!text.equals("")) {
                String mathCharacter = tvMathCharacter.getText().toString();
                if (mathCharacter.equals(CHARACTER_DIVISION)) {
                    readNumber(CHARACTER_DIVISION);
                } else {
                    lastReadNumber(mathCharacter, CHARACTER_DIVISION);
                }
            } else if (tvLastNumber.length() > 0) {
                character = CHARACTER_DIVISION;
                tvMathCharacter.setText(character);
            }
        });
        btnMultiplication.setOnClickListener(v -> {
            String text = etNumber.getText().toString();
            if (!text.equals("")) {
                String mathCharacter = tvMathCharacter.getText().toString();
                if (mathCharacter.equals(CHARACTER_MULTIPLICATION)) {
                    readNumber(CHARACTER_MULTIPLICATION);
                } else {
                    lastReadNumber(mathCharacter, CHARACTER_MULTIPLICATION);
                }
            } else if (tvLastNumber.length() > 0) {
                character = CHARACTER_MULTIPLICATION;
                tvMathCharacter.setText(character);
            }
        });
        btnMinus.setOnClickListener(v -> {
            String text = etNumber.getText().toString();
            if (!text.equals("")) {
                String mathCharacter = tvMathCharacter.getText().toString();
                if (mathCharacter.equals(CHARACTER_MINUS)) {
                    readNumber(CHARACTER_MINUS);
                } else {
                    lastReadNumber(mathCharacter, CHARACTER_MINUS);
                }
            } else if (tvLastNumber.length() > 0) {
                character = CHARACTER_MINUS;
                tvMathCharacter.setText(character);
            }
        });
        btnPlus.setOnClickListener(v -> {
            String text = etNumber.getText().toString();
            if (!text.equals("")) {
                String mathCharacter = tvMathCharacter.getText().toString();
                if (mathCharacter.equals(CHARACTER_PLUS)) {
                    readNumber(CHARACTER_PLUS);
                } else {
                    lastReadNumber(mathCharacter, CHARACTER_PLUS);
                }
            } else if (tvLastNumber.length() > 0) {
                character = CHARACTER_PLUS;
                tvMathCharacter.setText(character);
            }
        });
        btnPercent.setOnClickListener(v -> {
            String text = etNumber.getText().toString();
            if (!text.equals("")) {
                String mathCharacter = tvMathCharacter.getText().toString();
                if (mathCharacter.equals(CHARACTER_PERCENT)) {
                    readNumber(CHARACTER_PERCENT);
                } else {
                    lastReadNumber(mathCharacter, CHARACTER_PERCENT);
                }
            } else if (tvLastNumber.length() > 0) {
                character = CHARACTER_PERCENT;
                tvMathCharacter.setText(character);
            }
        });

        btn1.setOnClickListener(v -> {
            if (etNumber.length() <= NUMBER_LIMIT) {
                if (etNumber.getText().toString().equals("0") || etNumber.getText().toString().isEmpty()) {
                    etNumber.setText("1");
                } else {
                    etNumber.append("1");
                }
            }
        });
        btn2.setOnClickListener(v -> {
            if (etNumber.length() <= NUMBER_LIMIT) {
                if (etNumber.getText().toString().equals("0") || etNumber.getText().toString().isEmpty()) {
                    etNumber.setText("2");
                } else {
                    etNumber.append("2");
                }
            }
        });
        btn3.setOnClickListener(v -> {
            if (etNumber.length() <= NUMBER_LIMIT) {
                if (etNumber.getText().toString().equals("0") || etNumber.getText().toString().isEmpty()) {
                    etNumber.setText("3");
                } else {
                    etNumber.append("3");
                }
            }
        });
        btn4.setOnClickListener(v -> {
            if (etNumber.length() <= NUMBER_LIMIT) {
                if (etNumber.getText().toString().equals("0") || etNumber.getText().toString().isEmpty()) {
                    etNumber.setText("4");
                } else {
                    etNumber.append("4");
                }
            }
        });
        btn5.setOnClickListener(v -> {
            if (etNumber.length() <= NUMBER_LIMIT) {
                if (etNumber.getText().toString().equals("0") || etNumber.getText().toString().isEmpty()) {
                    etNumber.setText("5");
                } else {
                    etNumber.append("5");
                }
            }
        });
        btn6.setOnClickListener(v -> {
            if (etNumber.length() <= NUMBER_LIMIT) {
                if (etNumber.getText().toString().equals("0") || etNumber.getText().toString().isEmpty()) {
                    etNumber.setText("6");
                } else {
                    etNumber.append("6");
                }
            }
        });
        btn7.setOnClickListener(v -> {
            if (etNumber.length() <= NUMBER_LIMIT) {
                if (etNumber.getText().toString().equals("0") || etNumber.getText().toString().isEmpty()) {
                    etNumber.setText("7");
                } else {
                    etNumber.append("7");
                }
            }
        });
        btn8.setOnClickListener(v -> {
            if (etNumber.length() <= NUMBER_LIMIT) {
                if (etNumber.getText().toString().equals("0") || etNumber.getText().toString().isEmpty()) {
                    etNumber.setText("8");
                } else {
                    etNumber.append("8");
                }
            }
        });
        btn9.setOnClickListener(v -> {
            if (etNumber.length() <= NUMBER_LIMIT) {
                if (etNumber.getText().toString().equals("0") || etNumber.getText().toString().isEmpty()) {
                    etNumber.setText("9");
                } else {
                    etNumber.append("9");
                }
            }
        });
        btn0.setOnClickListener(v -> {
            if (etNumber.length() <= NUMBER_LIMIT) {
                if (!etNumber.getText().toString().startsWith("0")) {
                    etNumber.append("0");
                }
            }
        });

        btnEquals.setOnClickListener(v -> {
            String character = tvMathCharacter.getText().toString();
            String number = etNumber.getText().toString();
            String last = tvLastNumber.getText().toString();
            if (last.length() > 0 && number.length() > 0) {
                switch (character) {
                    case CHARACTER_PLUS:
                        etNumber.setText(sortNumber(Double.parseDouble(last) + Double.parseDouble(number)));
                        break;
                    case CHARACTER_MINUS:
                        etNumber.setText(sortNumber(Double.parseDouble(last) - Double.parseDouble(number)));
                        break;
                    case CHARACTER_MULTIPLICATION:
                        etNumber.setText(sortNumber(Double.parseDouble(last) * Double.parseDouble(number)));
                        break;
                    case CHARACTER_DIVISION:
                        if (etNumber.getText().toString().equals("0")) {
                            Toast.makeText(this, R.string.error_division_zero, Toast.LENGTH_SHORT).show();
                        } else {
                            etNumber.setText(sortNumber(Double.parseDouble(last) / Double.parseDouble(number)));
                        }
                        break;
                    case CHARACTER_PERCENT:
                        etNumber.setText(sortNumber(Double.parseDouble(last) / 100 * Double.parseDouble(number)));
                        break;
                }
                tvMathCharacter.setText("");
                tvLastNumber.setText("");
                isNum1 = false;
                isNum2 = false;
            } else if (last.length() > 0) {
                etNumber.setText(last);
                tvMathCharacter.setText("");
                tvLastNumber.setText("");
                isNum1 = false;
                isNum2 = false;
            }
        });

    }

    private void findUI() {
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btn0 = findViewById(R.id.btn_0);
        btnPlus = findViewById(R.id.btn_plus);
        btnPoint = findViewById(R.id.btn_point);
        btnClear = findViewById(R.id.btn_clear);
        btnMinus = findViewById(R.id.btn_minus);
        btnEquals = findViewById(R.id.btn_equals);
        btnPercent = findViewById(R.id.btn_percent);
        btnDivision = findViewById(R.id.btn_division);
        btnBackspace = findViewById(R.id.btn_backspace);
        btnPlusMinus = findViewById(R.id.btn_plus_minus);
        btnMultiplication = findViewById(R.id.btn_multiplication);

        etNumber = findViewById(R.id.et_number);
        tvLastNumber = findViewById(R.id.tv_last_number);
        tvMathCharacter = findViewById(R.id.tv_math_character);
    }

    private void setDefaultState() {
        number2 = 0.0;
        isNum1 = false;
        isNum2 = false;
        character = null;
        etNumber.setText("0");
        tvLastNumber.setText("");
        arithmeticCharNumber = 0;
        tvMathCharacter.setText("");
    }

    private String sortNumber(double num) {
        String result = "";
        long longNum = (long) num;
        String stringNum = String.valueOf(num);
        int indexPoint = stringNum.indexOf(".");
        String stringQ = stringNum.substring(indexPoint + 1);
        if (stringNum.contains("E") || stringNum.contains("e")) {
            result = stringNum;
        } else if (stringQ.length() == 1 && stringQ.startsWith("0")) {
            result = String.valueOf(longNum);
        } else if (stringQ.length() >= 12) {
            result = stringNum.substring(0, 12);
        } else {
            result = stringNum;
        }
        return result;
    }

    private void readNumber(String mCharacter) {
        String text = etNumber.getText().toString();
        arithmeticCharNumber++;
        if (arithmeticCharNumber >= 30) {
            Toast.makeText(this, "No more than 30 operators can be entered", Toast.LENGTH_SHORT).show();
        } else {
            if (!isNum1) {
                lastNumber = Double.parseDouble(text);
                etNumber.setText("");
                isNum1 = true;
            } else if (isNum1 && !isNum2) {
                number2 = Double.parseDouble(text);
                switch (mCharacter) {
                    case CHARACTER_PLUS:
                        lastNumber = lastNumber + number2;
                        break;
                    case CHARACTER_MINUS:
                        lastNumber = lastNumber - number2;
                        break;
                    case CHARACTER_MULTIPLICATION:
                        lastNumber = lastNumber * number2;
                        break;
                    case CHARACTER_DIVISION:
                        if (number2 == 0.0) {
                            Toast.makeText(this, R.string.error_division_zero, Toast.LENGTH_SHORT).show();
                        } else {
                            lastNumber = lastNumber / number2;
                        }
                        break;
                    case CHARACTER_PERCENT:
                        lastNumber = lastNumber / 100 * number2;
                        break;
                }
                etNumber.setText("");
                isNum1 = true;
            }

            tvLastNumber.setText(sortNumber(lastNumber));
            tvMathCharacter.setText(mCharacter);
        }
    }

    private void lastReadNumber(String mCharacter, String mathCharacter) {
        String text = etNumber.getText().toString();
        switch (mCharacter) {
            case CHARACTER_MULTIPLICATION:
                lastNumber = lastNumber * Double.parseDouble(text);
                break;
            case CHARACTER_DIVISION:
                if (text.equals("0")) {
                    Toast.makeText(this, R.string.error_division_zero, Toast.LENGTH_SHORT).show();
                } else {
                    lastNumber = lastNumber / Double.parseDouble(text);
                }
                break;
            case CHARACTER_MINUS:
                lastNumber = lastNumber - Double.parseDouble(text);
                break;
            case CHARACTER_PLUS:
                lastNumber = lastNumber + Double.parseDouble(text);
                break;
            case CHARACTER_PERCENT:
                lastNumber = lastNumber / 100 * Double.parseDouble(text);
                break;
            default:
                readNumber(mathCharacter);
        }
        etNumber.setText("");
        tvLastNumber.setText(sortNumber(lastNumber));
        arithmeticCharNumber = 0;
        character = mathCharacter;
        tvMathCharacter.setText(character);
    }

}
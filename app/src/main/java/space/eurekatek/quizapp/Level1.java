package space.eurekatek.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Level1 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;

    public int numLeft; // переменная для левой картинки + текст
    public int numRight; // переменная для правой картинки + текст
    Array array = new Array(); // создали новый объект из класса Array
    Random random = new Random(); // для генерации случайных чисел
    public int count = 0; // счетчик правильных ответов


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level1); // Установили текст

        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        // Код который скругляет углы левой картинки

        img_left.setClipToOutline(true);

        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        // Код который скругляет углы правой картинки

        img_right.setClipToOutline(true);

        // Путь к левой TextView
        final TextView text_left = findViewById(R.id.text_left);

        // Путь к правой TextView
        final TextView text_right = findViewById(R.id.text_right);

        // Развернуть игру на весь экран - начало

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        // Развернуть игру на весь экран - конец

        // Вызов диалогового окна в начале игры

        dialog = new Dialog(this); // Создаём новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // скрываем заголовок диалогового окна
        dialog.setContentView(R.layout.previewdialog); // путь к макету диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // прозрачный фон диалогового окна
        dialog.setCancelable(false); // диалог нельзя закрыть кнопкой "Назад"

        // кнопка которая закрывает диалоговое окно - начало
        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // обрабатываем нажатие кнопки - начало

                try {
                    // вернуться назад к выбору уровня - начало
                    Intent intent = new Intent(Level1.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                    // вернуться назад к выбору уровня - конец
                }catch (Exception e){

                }
                dialog.dismiss(); // закрываем диалоговое окно

                // обрабатываем нажатие кнопки - конец
            }
        });

        // кнопка которая закрывает диалоговое окно - конец

        // кнопка "продолжить" - начало

        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss(); // закрываем диалоговое окно
            }
        });
        // кнопка "продолжить" - конец

        dialog.show(); // показать диалоговое окно

        // ________________________________
        // Вызов диалогового окна в конце игры

        dialogEnd = new Dialog(this); // Создаём новое диалоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE); // скрываем заголовок диалогового окна
        dialogEnd.setContentView(R.layout.dialogend); // путь к макету диалогового окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // прозрачный фон диалогового окна
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false); // диалог нельзя закрыть кнопкой "Назад"

        // кнопка которая закрывает диалоговое окно - начало
        TextView btnclose2 = (TextView)dialogEnd.findViewById(R.id.btnclose);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // обрабатываем нажатие кнопки - начало

                try {
                    // вернуться назад к выбору уровня - начало
                    Intent intent = new Intent(Level1.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                    // вернуться назад к выбору уровня - конец
                }catch (Exception e){

                }
                dialogEnd.dismiss(); // закрываем диалоговое окно

                // обрабатываем нажатие кнопки - конец
            }
        });

        // кнопка которая закрывает диалоговое окно - конец

        // кнопка "продолжить" - начало

        Button btncontinue2 = (Button)dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level1.this, Level2.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {
                    // Здесь кода не будет
                }
                dialogEnd.dismiss(); // закрываем диалоговое окно
            }
        });
        // кнопка "продолжить" - конец
        // ________________________________

        // кнопка "Назад" - начало
            Button btn_back = (Button)findViewById(R.id.button_back);
            btn_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // обрабатываем нажатие кнопки "назад" - начало
                    try {
                        Intent intent= new Intent(Level1.this, GameLevels.class);
                        startActivity(intent);
                        finish();
                    }catch (Exception e){

                    }
                    // обрабатываем нажатие кнопки "назад" - конец
                }
            });
        // кнопка "Назад" - конец


        // массив для прогресса игры - начало
        final int[] progress={
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5, R.id.point6,
                R.id.point7, R.id.point8, R.id.point9, R.id.point10, R.id.point11,
                R.id.point12, R.id.point13, R.id.point14, R.id.point15, R.id.point16,
                R.id.point17, R.id.point18, R.id.point19, R.id.point20,
        };

        // массив для прогресса игры - конец

        // подключаем анимацию - начало
        final Animation a = AnimationUtils.loadAnimation(Level1.this, R.anim.alpha);
        // подключаем анимацию - конец

        numLeft = random.nextInt(10); // Генерируем случайное число от 0 до 9
        img_left.setImageResource(array.images1[numLeft]); // достаем из массива картинку
        text_left.setText(array.texts1[numLeft]); // достаем из массива текст

        numRight = random.nextInt(10);

        // цикл проверяющий равенство чисел - начало
        while (numLeft==numRight){
            numRight =  random.nextInt(10);
        }
        // цикл проверяющий равенство чисел - конец
        img_right.setImageResource(array.images1[numRight]); //достаем из массива картинку
        text_right.setText(array.texts1[numRight]); // достаем из массива текст

        // обрабатываем нажатие на левую картинку - начало
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // условие касания картинки - начало
                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    // если коснулся картинку - начало
                    img_right.setEnabled(false); // блокируем правую картинку
                    if (numLeft>numRight){
                        img_left.setImageResource(R.drawable.img_true);
                    }else {
                        img_left.setImageResource(R.drawable.img_false);
                    }
                    // если коснулся картинки - конец
                }else if (motionEvent.getAction()==MotionEvent.ACTION_UP){
                    // если отпустил палец - начало
                    if (numLeft>numRight){
                        // если левая картинка больше
                        if (count<20){
                            count=count+1;
                        }
                        // закрашиваем прогресс серым цветом - начало
                        for (int i=0; i<20; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        // закрашиваем прогресс серым цветом - конец
                        // определяем правильные ответы и закрашиваем зеленым - начало
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        // определяем правильные ответы и закрашиваем зеоным - конец
                    }else {
                        // если левая картинка меньше
                        if (count>0){
                            if (count==1){
                                count=0;
                            }else {
                                count=count-2;
                            }
                        }
                        // закрашиваем прогресс серым цветом - начало
                        for (int i=0; i<19; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        // закрашиваем прогресс серым цветом - конец
                        // определяем правильные ответы и закрашиваем зеленым - начало
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        // определяем правильные ответы и закрашиваем зеоным - конец
                    }
                    // если отпустил палец - конец
                    if (count==20) {
                        // ВЫХОД ИЗ УРОВНЯ
                        dialogEnd.show();
                    }else{
                        numLeft = random.nextInt(10); // Генерируем случайное число от 0 до 9
                        img_left.setImageResource(array.images1[numLeft]); // достаем из массива картинку
                        img_left.startAnimation(a);
                        text_left.setText(array.texts1[numLeft]); // достаем из массива текст
                        numRight = random.nextInt(10);
                        // цикл проверяющий равенство чисел - начало
                        while (numLeft==numRight){
                        numRight =  random.nextInt(10);
                        }
                        // цикл проверяющий равенство чисел - конец
                        img_right.setImageResource(array.images1[numRight]); //достаем из массива картинку
                        img_right.startAnimation(a);
                        text_right.setText(array.texts1[numRight]); // достаем из массива текст

                        img_right.setEnabled(true); // включаем обратно правую картинку
                        }
                }
                // условие касания картинка - конец
                return true;
            }
        });
        // обрабатываем нажатие на левую картинку - конец

        // обрабатываем нажатие на правую картинку - начало
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // условие касания картинки - начало
                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    // если коснулся картинку - начало
                    img_left.setEnabled(false); // блокируем левую картинку
                    if (numLeft<numRight){
                        img_right.setImageResource(R.drawable.img_true);
                    }else {
                        img_right.setImageResource(R.drawable.img_false);
                    }
                    // если коснулся картинки - конец
                }else if (motionEvent.getAction()==MotionEvent.ACTION_UP){
                    // если отпустил палец - начало
                    if (numLeft<numRight){
                        // если правая картинка больше
                        if (count<20){
                            count=count+1;
                        }
                        // закрашиваем прогресс серым цветом - начало
                        for (int i=0; i<20; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        // закрашиваем прогресс серым цветом - конец
                        // определяем правильные ответы и закрашиваем зеленым - начало
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        // определяем правильные ответы и закрашиваем зеоным - конец
                    }else {
                        // если правая картинка меньше
                        if (count>0){
                            if (count==1){
                                count=0;
                            }else {
                                count=count-2;
                            }
                        }
                        // закрашиваем прогресс серым цветом - начало
                        for (int i=0; i<19; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        // закрашиваем прогресс серым цветом - конец
                        // определяем правильные ответы и закрашиваем зеленым - начало
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        // определяем правильные ответы и закрашиваем зеоным - конец
                    }
                    // если отпустил палец - конец
                    if (count==20) {
                        // ВЫХОД ИЗ УРОВНЯ
                        dialogEnd.show();
                    }else{
                        numLeft = random.nextInt(10); // Генерируем случайное число от 0 до 9
                        img_left.setImageResource(array.images1[numLeft]); // достаем из массива картинку
                        img_left.startAnimation(a);
                        text_left.setText(array.texts1[numLeft]); // достаем из массива текст
                        numRight = random.nextInt(10);
                        // цикл проверяющий равенство чисел - начало
                        while (numLeft==numRight){
                            numRight =  random.nextInt(10);
                        }
                        // цикл проверяющий равенство чисел - конец
                        img_right.setImageResource(array.images1[numRight]); //достаем из массива картинку
                        img_right.startAnimation(a);
                        text_right.setText(array.texts1[numRight]); // достаем из массива текст

                        img_left.setEnabled(true); // включаем обратно левую картинку
                    }
                }
                // условие касания картинка - конец
                return true;
            }
        });
        // обрабатываем нажатие на правую картинку - конец

    }
    // системная кнопка "назад" - начало
    @Override
    public void onBackPressed(){
        // обрабатываем нажатие кнопки "назад" - начало
        try {
            Intent intent= new Intent(Level1.this, GameLevels.class);
            startActivity(intent);
            finish();
        }catch (Exception e){

        }
        // обрабатываем нажатие кнопки "назад" - конец
    }
    // системная кнопка "назад" - конец
}
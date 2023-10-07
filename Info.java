package Excteption;
import java.io.*;
import java.util.Scanner;

public class Info {
    static Scanner iScanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        System.out.println(information());
    }
    public static String information() throws Exception{

        System.out.println("Введите следующие данные о себе через пробел в произвольном порядке: Фамилия, Имя, Отчество, дата рождения формата(dd.mm.yyyy), номер телефона, пол(символо f или m)");
        String information = iScanner.nextLine();
        String[] info = information.split(" ");

        try {                       //Делаем проверку на правильное количество данных, если не совпадает то выдаем ошибку
            if(info.length != 6){   // и обрабатываем ее.
                throw new Exception();
            }
        }catch (Exception e) {  // Обработка исключения. И вывод кода ошибки.
            System.out.println("Вы ввели не верное количество данных");
            return information();

        }

        parse(info);

        return "Операция успешно выполнена";
    }
    public static String parse(String[] inf) throws MyException{       // Метод для удобного разделения информации для дальнейшей работы с ними.
        String name = null;
        String surname = null;
        String surname_2 = null;
        String gender = null;
        String date = null;
        String number = null;
        for (int i = 0; i < inf.length; i++) {
            boolean Flag = true;
            if(inf[i].equals("f") || inf[i].equals("m") || inf[i].length() == 1){
                gender = inf[i];
            }
            for(char c : inf[i].toCharArray())
                if(Character.isDigit(c)) {
                    if(inf[i].length() == 10){
                        date = inf[i];
                    }else{
                        number = inf[i];
                    }

                    break;

                }else if( Flag && inf[i].length() != 1 ){
                    name = inf[i];
                    surname = inf[i + 1];
                    surname_2 = inf[i + 2];
                    Flag = false;
                    i = i + 2;
                }


        }
        mytest(name, surname, surname_2, date, number, gender);

        SaveInfo(name, surname, surname_2, date, number, gender);

    return "0";
    }
    public static void SaveInfo(String name,String surname,String surname_2,String date,String number,String gender){
        //метод для записи информации 
        try(FileWriter SaveInfor = new FileWriter("Info"))
        {
            SaveInfor.write(name + " " + surname + " " + surname_2 + " " + date + " " + number+ " " + gender);
            System.out.println("Файл успешно записан");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage() + " Ошибка записи ");
        }
    }

    public static void mytest(String name,String surname,String surname_2,String date,String number,String gender) throws MyException {
        try{
            for(char c : name.toCharArray())
                if(Character.isDigit(c)){
                throw new Exception();
            }
        } catch (Exception e) {
            throw new MyException("Ошибка в Имени", e);
        }
        try{
            for(char c : surname.toCharArray())
                if(Character.isDigit(c)){
                    throw new Exception();
                }
        } catch (Exception e) {
            throw new MyException("Ошибка в Фамилии", e);
        }
        try{
            for(char c : surname_2.toCharArray())
                if(Character.isDigit(c)){
                    throw new Exception();
                }
        } catch (Exception e) {
            throw new MyException("Ошибка в Отчестве", e);
        }
        try{
            String[] dateInfo = date.split(".");
            for(int i = 0; i < dateInfo.length; i++) {
                int x = Integer.parseInt(dateInfo[1]);
                int y = Integer.parseInt(dateInfo[2]);
                int z = Integer.parseInt(dateInfo[3]);
                if (x > 31 || y > 12 || z > 2023) {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            throw new MyException("Ошибка в Дате рождения", e);
        }
        try{
            long x = Long.parseLong(number);

        } catch (Exception e) {
            throw new MyException("Ошибка в номере телефона", e);
        }
        try{

            if(gender.equals("f") || gender.equals("m")){

            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new MyException("Неправильный ввод пола", e);
        }

    }
}
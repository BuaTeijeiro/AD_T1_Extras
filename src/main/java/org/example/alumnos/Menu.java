package org.example.alumnos;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;

public class Menu {
    private String prompt;
    private boolean active;
    private Map<Integer,Method> options = new HashMap<>();

    public Menu(String prompt) {
        this.prompt = prompt;
        this.active = false;
    }

    public boolean isActive() {
        return active;
    }

    public Set<Integer> getOptions(){
        return this.options.keySet();
    }

    private Method getMethod(int position){
        return this.options.get(position);
    }

    public String getPrompt() {
        return prompt;
    }

    private void setActive(boolean active) {
        this.active = active;
    }

    public void addOption(int pos, String methodName) throws NoSuchMethodException{
        Method method = Menu.class.getMethod(methodName);
        options.putIfAbsent(pos, method);
    }

    public void addOption(int pos, String methodName, Class<?> clase) throws NoSuchMethodException{
        Method method = clase.getMethod(methodName);
        options.putIfAbsent(pos, method);
    }

    private boolean hasOption(Integer option){
        return getOptions().contains(option);
    }

    private boolean hasOption(String option){
        try{
            Integer optionNumber = Integer.valueOf(option);
            return hasOption(optionNumber);
        } catch (NumberFormatException e){
            return false;
        }
    }

    public void activate(){
        entrar();
        while (isActive()){
            display();
            Method selectedMethod = getMethod(getOption());
            try {
                selectedMethod.invoke(this);
            } catch (IllegalAccessException | InvocationTargetException e){
                System.out.println("Lo sentimos, no se puede realizar la acción");
            }
        }

    }

    public void salir(){
        setActive(false);
    }

    private void entrar(){
        setActive(true);
    }

    private void display(){
        StringBuilder menuText = new StringBuilder(getPrompt()).append("\n");
        for (Integer option: getOptions()){
            menuText.append(option)
                    .append(". ")
                    .append(getMethod(option).getName())
                    .append("\n");
        }
        System.out.println(menuText);
    }

    private Integer getOption(){
        String selectedOption = "";
        while (!hasOption(selectedOption = new Scanner(System.in).nextLine())){
            System.out.println("Esa opcion no es posible, inténtelo de nuevo\n");
        }
        return Integer.valueOf(selectedOption);
    }

}

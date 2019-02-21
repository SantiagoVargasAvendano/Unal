/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Date;

/**
 *
 * @author Estudiante
 */
public class PartialTime extends Professor{
    private String category;
    private int classHours;

    public PartialTime(String id, String name, Date hiringDate, String school, String department, String category, int classHours) {
        super(id, name, hiringDate, school, department);
        this.category = category;
        this.classHours = classHours;
    }

    @Override
    public float paySalary() {
        float salario = 0;
        switch(category){
            case "A":
                salario = this.classHours*60000;
                break;
            case "B":
                salario = this.classHours*80000;
                break;
            case "C":
                salario = this.classHours*100000;
                break;
        }
        return salario;
    }
    
    
}

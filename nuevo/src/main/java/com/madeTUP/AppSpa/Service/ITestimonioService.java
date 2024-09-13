/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.madeTUP.AppSpa.Service;

import com.madeTUP.AppSpa.Model.Testimonio;
import java.util.List;

/**
 *
 * @author Virginia
 */
public interface ITestimonioService {
    public List<Testimonio> getTestimonio();
    public void saveTestimonio (Testimonio testimonio);
    public void deleteTestimonio (Long id);
    public Testimonio findTestimonio (Long id);
    public void editTestimonio (Long id,String nombre,String testimonio);
    public void editTestimonioII (Testimonio testimonio);
}

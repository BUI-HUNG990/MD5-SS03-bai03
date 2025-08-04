package com.example.demo.controller;

import com.example.demo.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("view/studentForm.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        String address = request.getParameter("address");

        String errorMessage = null;
        int age = 0;

        if (name == null || name.isEmpty() ||
                ageStr == null || ageStr.isEmpty() ||
                address == null || address.isEmpty()) {
            errorMessage = "Vui lòng nhập đầy đủ thông tin.";
        } else {
            try {
                age = Integer.parseInt(ageStr);
                if (age <= 0) {
                    errorMessage = "Tuổi phải lớn hơn 0.";
                }
            } catch (NumberFormatException e) {
                errorMessage = "Tuổi phải là số.";
            }
        }

        if (errorMessage != null) {
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("view/studentForm.jsp").forward(request, response);
        } else {
            Student student = new Student(name, age, address);
            request.setAttribute("student", student);
            request.getRequestDispatcher("view/studentInfo.jsp").forward(request, response);
        }
    }
}
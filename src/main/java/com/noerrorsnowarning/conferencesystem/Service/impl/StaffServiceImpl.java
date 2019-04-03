package com.noerrorsnowarning.conferencesystem.Service.impl;

import com.noerrorsnowarning.conferencesystem.Service.StaffService;
import com.noerrorsnowarning.conferencesystem.dao.StaffMapper;
import com.noerrorsnowarning.conferencesystem.domain.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class StaffServiceImpl implements StaffService {

    private StaffMapper staffMapper;

    @Autowired
    public StaffServiceImpl(StaffMapper staffMapper) {
        this.staffMapper = staffMapper;
    }

    @Override
    public Staff queryStaffById(String id) {
        Staff staff = staffMapper.queryStaffById(id);

        //将数据库的英文字母转化为中文
        staff.setSsex(staff.getSsex().equals("M") ? "男" : "女");
        return staff;
    }

    @Override
    public boolean login(String id, String password) {

        boolean result = true;

        //sql语句是count(*),返回数量
        //根据返回值来判断是用户名和密码是否错误
        int login = staffMapper.queryStaffByIdAndPassword(id, password);
        if (login != 1) {
            result = false;
        } else {
            result = true;
        }

        return result;
    }

    @Override
    public int update(HttpServletRequest request) {

        String number=request.getParameter("num");
        String ID= (String) request.getSession().getAttribute("Sname");

        return staffMapper.update(ID,number);
    }
}
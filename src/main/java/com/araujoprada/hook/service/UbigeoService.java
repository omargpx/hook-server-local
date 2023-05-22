package com.araujoprada.hook.service;

import com.araujoprada.hook.entity.Department;
import com.araujoprada.hook.entity.District;
import com.araujoprada.hook.entity.Province;

import java.util.List;

public interface UbigeoService {
    List<Department> getDepartments();
    List<Province> getProvinces();
    List<District> getDistricts();
    Department getDepartmentById(int id);
    Province getProvinceById(int id);
    District getDistrictById(int id);

    //region filters
    Department findDepartmentByName(String name);
    Province findProvinceByName(String name);
    District findDistrictByName(String name);
    //endregion
}

package com.araujoprada.hook.service.logic;

import com.araujoprada.hook.entity.Department;
import com.araujoprada.hook.entity.District;
import com.araujoprada.hook.entity.Province;
import com.araujoprada.hook.repo.DepartmentDao;
import com.araujoprada.hook.repo.DistrictDao;
import com.araujoprada.hook.repo.ProvinceDao;
import com.araujoprada.hook.service.UbigeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbigeoServiceImp implements UbigeoService {

    //region repositories
    @Autowired
    private DepartmentDao department_repo;
    @Autowired
    private ProvinceDao province_repo;
    @Autowired
    private DistrictDao district_repo;
    //endregion

    @Override
    public List<Department> getDepartments() {
        return department_repo.findAll();
    }

    @Override
    public List<Province> getProvinces() {
        return province_repo.findAll();
    }

    @Override
    public List<District> getDistricts() {
        return district_repo.findAll();
    }

    @Override
    public Department getDepartmentById(int id) {
        return department_repo.findById(id).orElse(null);
    }

    @Override
    public Province getProvinceById(int id) {
        return province_repo.findById(id).orElse(null);
    }

    @Override
    public District getDistrictById(int id) {
        return district_repo.findById(id).orElse(null);
    }
}

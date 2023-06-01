package com.araujoprada.hook.service.logic;

import com.araujoprada.hook.entity.Department;
import com.araujoprada.hook.entity.District;
import com.araujoprada.hook.entity.Province;
import com.araujoprada.hook.errors.GUSException;
import com.araujoprada.hook.model.SERVICES;
import com.araujoprada.hook.repo.DepartmentDao;
import com.araujoprada.hook.repo.DistrictDao;
import com.araujoprada.hook.repo.ProvinceDao;
import com.araujoprada.hook.service.UbigeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        List<Department> departments = department_repo.findAll();
        if(!departments.isEmpty())
            return departments;
        throw new GUSException(SERVICES.UBIGEO_SERVICE.name(), null, HttpStatus.NO_CONTENT);
    }

    @Override
    public List<Province> getProvinces() {
        List<Province> provinces = province_repo.findAll();
        if (!provinces.isEmpty())
            return provinces;
        throw new GUSException(SERVICES.UBIGEO_SERVICE.name(),null, HttpStatus.NO_CONTENT);
    }

    @Override
    public List<District> getDistricts() {
        List<District> districts = district_repo.findAll();
        if (!districts.isEmpty())
            return districts;
        throw new GUSException(SERVICES.UBIGEO_SERVICE.name(),null, HttpStatus.NO_CONTENT);
    }

    @Override
    public Department getDepartmentById(int id) {
        Department department = department_repo.findById(id).orElse(null);
        if(null!=department)
            return department;
        throw new GUSException(SERVICES.UBIGEO_SERVICE.name(),null, HttpStatus.NOT_FOUND);
    }

    @Override
    public Province getProvinceById(int id) {
        Province province = province_repo.findById(id).orElse(null);
        if (null!=province)
            return province;
        throw new GUSException(SERVICES.UBIGEO_SERVICE.name(),null, HttpStatus.NOT_FOUND);
    }

    @Override
    public District getDistrictById(int id) {
        District district = district_repo.findById(id).orElse(null);
        if (null!=district)
            return district;
        throw new GUSException(SERVICES.UBIGEO_SERVICE.name(),null, HttpStatus.NOT_FOUND);
    }

    @Override
    public Department findDepartmentByName(String name) {
        Department department = department_repo.findFirstByNameContains(name);
        if(null!=department)
            return department;
        throw new GUSException(SERVICES.UBIGEO_SERVICE.name(),null, HttpStatus.NOT_FOUND);
    }

    @Override
    public Province findProvinceByName(String name) {
        Province province = province_repo.findFirstByNameContains(name);
        if(null!=province)
            return province;
        throw new GUSException(SERVICES.UBIGEO_SERVICE.name(),null,HttpStatus.NOT_FOUND);
    }

    @Override
    public District findDistrictByName(String name) {
        District district = district_repo.findFirstByNameContains(name);
        if(null!=district)
            return district;
        throw new GUSException(SERVICES.UBIGEO_SERVICE.name(),null,HttpStatus.NOT_FOUND);
    }
}

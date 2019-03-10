package com.noerrorsnowarning.conferencesystem.Service.impl;

import com.noerrorsnowarning.conferencesystem.Service.EquipmentService;
import com.noerrorsnowarning.conferencesystem.dao.EquipmentMapper;
import com.noerrorsnowarning.conferencesystem.domain.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private EquipmentMapper equipmentMapper;

    @Autowired
    public EquipmentServiceImpl(EquipmentMapper equipmentMapper) {
        this.equipmentMapper = equipmentMapper;
    }

    @Override
    public List<Equipment> getEquips() {

        List<Equipment> equipmentList = equipmentMapper.getEquips();

        return equipmentList;
    }

}

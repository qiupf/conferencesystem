package com.noerrorsnowarning.conferencesystem.Controller;

import com.noerrorsnowarning.conferencesystem.Service.EquipmentService;
import com.noerrorsnowarning.conferencesystem.Service.RoomService;
import com.noerrorsnowarning.conferencesystem.domain.Equipment;
import com.noerrorsnowarning.conferencesystem.domain.Room;
import com.noerrorsnowarning.conferencesystem.interceptor.Access;
import com.noerrorsnowarning.conferencesystem.tools.RoomGetParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/html")
public class AddRoomController {

    private RoomService roomService;
    private EquipmentService equipmentService;

    @Autowired
    AddRoomController(RoomService roomService, EquipmentService equipmentService) {
        this.roomService = roomService;
        this.equipmentService = equipmentService;
    }

    @RequestMapping(value = "/addRoom", method = RequestMethod.POST)
    @Access(auths = {"admin"})
    public String addRoom(HttpServletRequest request, Model model) throws ParseException {

        //大量的获取前端信息，放到Controller端不太好看，写到别的地方了
        RoomGetParameter roomGetParameter = new RoomGetParameter();
        Room room = roomGetParameter.getParameter(request);

        List<Equipment>equipmentList=equipmentService.getEquips();

        String[] equip = request.getParameterValues("equip");

        int result = roomService.RoomInsert(room,equip,equipmentList.size());

        if (result == 1) {
            model.addAttribute("message", "插入成功");
        } else {
            model.addAttribute("message", "插入失败");
        }

        model.addAttribute("equipList",equipmentList);

        return "html/addmeetingroom.html";
    }

}
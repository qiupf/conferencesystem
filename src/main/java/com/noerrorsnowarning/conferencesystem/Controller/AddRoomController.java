package com.noerrorsnowarning.conferencesystem.Controller;

import com.noerrorsnowarning.conferencesystem.Service.EquipmentService;
import com.noerrorsnowarning.conferencesystem.Service.RoomAndEquipService;
import com.noerrorsnowarning.conferencesystem.Service.RoomService;
import com.noerrorsnowarning.conferencesystem.domain.Equipment;
import com.noerrorsnowarning.conferencesystem.domain.Room;
import com.noerrorsnowarning.conferencesystem.interceptor.Access;
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
    private RoomAndEquipService roomAndEquipService;

    @Autowired
    AddRoomController(RoomService roomService, EquipmentService equipmentService, RoomAndEquipService roomAndEquipService) {
        this.roomService = roomService;
        this.equipmentService = equipmentService;
        this.roomAndEquipService = roomAndEquipService;
    }

    @RequestMapping(value = "/addRoom", method = RequestMethod.POST)
    @Access(auths = {"admin"})
    public String addRoom(HttpServletRequest request, Model model) throws ParseException {
        List<Equipment> equipmentList = equipmentService.getEquips();
        model.addAttribute("equipList", equipmentList);
        List<Room> roomList = roomService.getRoom();

        roomList = roomAndEquipService.roomAndEquip(roomList, equipmentList);
        model.addAttribute("roomList", roomList);

        return "html/addmeetingroom.html";
    }

    @RequestMapping(value = "/addnewroom", method = RequestMethod.POST)
    @Access(auths = {"admin"})
    public String addnewroom(HttpServletRequest request, Model model) throws ParseException {
        String id = request.getParameter("roomID");
        String name = request.getParameter("roomName");
        String num = request.getParameter("roomNum");
        String tnum = request.getParameter("tnum");
        String hnum = request.getParameter("hnum");
        String wnum = request.getParameter("wnum");
        String s=""+tnum+hnum+wnum;
        roomService.addRoom(id, name, num, s);

        List<Equipment> equipmentList = equipmentService.getEquips();
        model.addAttribute("equipList", equipmentList);
        List<Room> roomList = roomService.getRoom();
        roomList = roomAndEquipService.roomAndEquip(roomList, equipmentList);
        model.addAttribute("roomList", roomList);
        return "redirect:/html/addmeetingroom.html";
    }

    @RequestMapping(value = "/add1", method = RequestMethod.POST)
    @Access(auths = {"admin"})
    public String add1(HttpServletRequest request, Model model) throws ParseException {
        List<Equipment> equipmentList = equipmentService.getEquips();
        model.addAttribute("equipList", equipmentList);
        return "redirect:/html/addroomcontent.html";
    }

    @RequestMapping(value = "/addroomcontent.html", method = RequestMethod.GET)
    public String aa(Model model) {
        List<Equipment> equipmentList = equipmentService.getEquips();
        model.addAttribute("equipList", equipmentList);
        return "html/addroomcontent.html";
    }

}
package com.noerrorsnowarning.conferencesystem.Controller;

import com.noerrorsnowarning.conferencesystem.Service.*;
import com.noerrorsnowarning.conferencesystem.domain.ConferenceInfo;
import com.noerrorsnowarning.conferencesystem.domain.Equipment;
import com.noerrorsnowarning.conferencesystem.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class indexController {

    private ConferenceService conferenceService;
    private StaffService staffService;
    private EquipmentService equipmentService;
    private RoomService roomService;
    private RoomAndEquipService roomAndEquipService;

    @Autowired
    indexController(ConferenceService conferenceService,
                    StaffService staffService,
                    EquipmentService equipmentService,
                    RoomService roomService,
                    RoomAndEquipService roomAndEquipService) {
        this.conferenceService = conferenceService;
        this.staffService = staffService;
        this.equipmentService = equipmentService;
        this.roomService = roomService;
        this.roomAndEquipService = roomAndEquipService;
    }

    @RequestMapping(value = "index.html", method = RequestMethod.GET)
    public String indexHtml() {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/html/mymeeting2.html", method = RequestMethod.GET)
    public String mymeeting2(Model model, HttpServletRequest request) {

        String user = (String) request.getSession().getAttribute("Sname");

        //获取未参加的会议
        List<ConferenceInfo> conferenceList = conferenceService.searchCon(2, user);
        model.addAttribute("ConferenceList", conferenceList);
        System.out.println(conferenceList.get(0).getRoomID());
        return "html/mymeeting2";
    }

    @RequestMapping(value = "/html/mymeeting3.html", method = RequestMethod.GET)
    public String mymeeting3(Model model, HttpServletRequest request) {

        String user = (String) request.getSession().getAttribute("Sname");

        //获取历史会议
        List<ConferenceInfo> conferenceList = conferenceService.searchCon(3, user);
        model.addAttribute("ConferenceList", conferenceList);
        return "html/mymeeting3";
    }

    @RequestMapping(value = "/html/state1.html", method = RequestMethod.GET)
    public String state1() {
        return "html/state1.html";
    }

    @RequestMapping(value = "/html/state2.html", method = RequestMethod.GET)
    public String state2() {
        return "html/state2.html";
    }

    @RequestMapping(value = "/html/addmeetingroom.html", method = RequestMethod.GET)
    public String addMeetingRoom(Model model) {

        //获取设备信息显示到前端
        /*List<Equipment> equipList = equipmentService.getEquips();
        model.addAttribute("equipList", equipList);

        return "html/addmeetingroom.html";*/
        List<Room> roomList = roomService.getRoom();
        List<Equipment> equipmentList = equipmentService.getEquips();
        model.addAttribute("equipList", equipmentList);

        roomList = roomAndEquipService.roomAndEquip(roomList, equipmentList);
        for (Room room : roomList) {
            room.setRemoveurl("removeroom?roomID=" + room.getRoomID());
            room.setModifyurl("modify?roomID=" + room.getRoomID());
        }
        model.addAttribute("roomList", roomList);
        return "html/addmeetingroom.html";
    }

    @RequestMapping(value = "/html/addguest.html", method = RequestMethod.GET)
    public String addGuest() {
        return "html/addguest.html";
    }

    @RequestMapping(value = "/html/setting.html", method = RequestMethod.GET)
    public String setting() {
        return "html/setting.html";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String login() {
        return "admin/login";
    }

    @RequestMapping(value = "/html/addmap.html", method = RequestMethod.GET)
    public String addMap() {
        return "html/addmap";
    }

    @RequestMapping(value = "/html/addstaff.html", method = RequestMethod.GET)
    public String addStaff() {
        return "html/addstaff";
    }

}
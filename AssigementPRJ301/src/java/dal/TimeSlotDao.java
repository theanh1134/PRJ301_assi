package dal;

import dal.DBContext;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TimeSlot;
import java.sql.*;

public class TimeSlotDao extends DBContext{
    public ArrayList<TimeSlot> listTime() {
        ArrayList<TimeSlot> slots = new ArrayList<>();
        connection = getConnection();
        String sql = "SELECT [tid], [tname], [tfrom], [tto] FROM [dbo].[TimeSlot]";
        
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int tid_slot = resultSet.getInt("tid");
                String tname_slot = resultSet.getString("tname").trim();
                Time tfrom_slot = resultSet.getTime("tfrom");
                Time tto_slot = resultSet.getTime("tto");
                
                // Chuyển đổi Time thành LocalTime
                LocalTime timeFrom = tfrom_slot.toLocalTime();
                LocalTime timeTo = tto_slot.toLocalTime();
                
                TimeSlot slot = new TimeSlot(tid_slot, tname_slot, timeFrom, timeTo);
                slots.add(slot);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimeSlotDao.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        return slots;
    }
     public static void main(String[] args) {
        TimeSlotDao timeSlotDao = new TimeSlotDao();
        ArrayList<TimeSlot> timeSlots = timeSlotDao.listTime();
        
        if (timeSlots != null && !timeSlots.isEmpty()) {
            System.out.println("List of TimeSlots:");
            for (TimeSlot slot : timeSlots) {
                System.out.println("TimeSlot{id=" + slot.getId() + 
                                   ", name=" + slot.getName() + 
                                   ", timeFrom=" + slot.getTimeFrom() + 
                                   ", timeTo=" + slot.getTimeTo() + "}");
            }
        } else {
            System.out.println("No TimeSlots found.");
        }
    }
}

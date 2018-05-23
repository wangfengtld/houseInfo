package com.tl.houseinfo;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;

import com.tl.views.SeatTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/21.
 */

public class SeatInfoActivity extends Activity {
    public SeatTable seatTableView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seatinfo);

        seatTableView = (SeatTable) findViewById(R.id.seatView);
        seatTableView.setScreenName("8号厅荧幕");//设置屏幕名称
        seatTableView.setMaxSelected(4);//淘宝电影设置最多4个选中

        //制造数据
        final List<ArrayList<Seat>> seatList = new ArrayList<ArrayList<Seat>>();
        int rows = 15;
        int column = 15;
        for (int i = 0; i < rows; i++) {
            ArrayList<Seat> list = new ArrayList<Seat>();

            for (int j = 0; j < column; j++) {
                Seat seat = new Seat();
                seat.setRow(i);
                seat.setColumn(j);
                if (j == 2 || j == 7) {
                    seat.setState(seatTableView.SEAT_TYPE_NOT_AVAILABLE);
                } else {
                    seat.setState(seatTableView.SEAT_TYPE_AVAILABLE);
                }
                list.add(seat);
            }
            seatList.add(list);
        }
        seatList.get(1).get(5).setState(seatTableView.SEAT_TYPE_SOLD);

        seatTableView.setSeatChecker(new SeatTable.SeatChecker() {

            @Override
            public boolean isValidSeat(int row, int column) {
//                Log.d("wangfeng", "isValidSeat row: " + row + " column: " + column);

//                if(column == 2) {
//                    return false;
//                }
//                if(column == 8) {
//                    return false;
//                }
                if (seatList.get(row).get(column).getState() == SeatTable.SEAT_TYPE_NOT_AVAILABLE) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean isSold(int row, int column) {
//                if(row == 0 && column == 0){
//                    return true;
//                }
                if (seatList.get(row).get(column).getState() == SeatTable.SEAT_TYPE_SOLD) {
                    return true;
                }

                return false;
            }

            @Override
            public void checked(int row, int column) {
                Log.d("wangfeng", "checked row: " + row + " column: " + column);

            }

            @Override
            public void unCheck(int row, int column) {
                Log.d("wangfeng", "unCheck row: " + row + " column: " + column);

            }

            @Override
            public String[] checkedSeatTxt(int row, int column) {
//                Log.d("wangfeng", "checkedSeatTxt row: " + row + " column: " + column);
                return null;
            }

        });
        seatTableView.setSeatTextBySelf(new SeatTable.SeatTextBySelf() {
            @Override
            public void drawText(Canvas canvas, int row, int column, float top, float left) {
                String rowText = row + 1 + "排";
                String columnText = column + 1 + "座";
                seatTableView.drawText(canvas, row, column, top, left, rowText, columnText);
            }
        });
        seatTableView.setData(seatList.size(), seatList.get(0).size());
    }
}

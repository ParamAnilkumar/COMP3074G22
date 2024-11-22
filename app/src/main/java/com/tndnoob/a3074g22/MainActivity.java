package com.tndnoob.a3074g22;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.tndnoob.a3074g22.Order;
import com.tndnoob.a3074g22.OrderAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView orderListView;
    private List<Order> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orderListView = findViewById(R.id.orderListView);
        orders = new ArrayList<>();
        createDummyData(); // Add some dummy data

        OrderAdapter adapter = new OrderAdapter(this, orders);
        orderListView.setAdapter(adapter);

        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle search submit (optional)
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterOrders(newText);
                return true;
            }
        });
    }

    private void createDummyData() {
        orders.add(new Order("ORD001", "Open"));
        orders.add(new Order("ORD002", "Closed"));
        orders.add(new Order("ORD003", "Open"));
        orders.add(new Order("ORD004", "Closed"));
        orders.add(new Order("ORD005", "Open"));
    }

    private void filterOrders(String query) {
        List<Order> filteredList = new ArrayList<>();
        for (Order order : orders) {
            if (order.getOrderNumber().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(order);
            }
        }
        OrderAdapter filteredAdapter = new OrderAdapter(this, filteredList);
        orderListView.setAdapter(filteredAdapter);
    }
}

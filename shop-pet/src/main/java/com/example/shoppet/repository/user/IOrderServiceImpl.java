//package com.example.shoppet.repository.user;
//
//import com.example.shoppet.dao.user.BillsDao;
//import com.example.shoppet.dao.user.OrderDao;
//import com.example.shoppet.dto.CartDto;
//import com.example.shoppet.dto.Order;
//import com.example.shoppet.entity.user.BillDetail;
//import com.example.shoppet.entity.user.Bills;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class IOrderServiceImpl implements IOrderService {
//
//    @Autowired
//    private OrderDao orderDao = new OrderDao();
//
////    public Bills GetBillsByID(long id) {
////        List<Bills> listProducts = orderDao.GetBillByID(id);
////        return listProducts.get(0);
////    }
//
//    @Override
//    public int AddOrder(Order order) {
//        return orderDao.AddOrder(order);
//    }
//
//    @Override
//    public void AddBillsDetail(HashMap<Long, Order> order) {
//
//        for (Map.Entry<Long,Order> itemCart : order.entrySet()){
//            Order billDetail = new Order();
//            billDetail.setId_product(itemCart.getValue().getProduct().getId_product());
//            billDetail.setQuanty(itemCart.getValue().getQuanty());
//            billDetail.setTotal(itemCart.getValue().getTotalPrice());
//            billsDao.AddBillsDetail(billDetail);
//        }
//    }
//
//}

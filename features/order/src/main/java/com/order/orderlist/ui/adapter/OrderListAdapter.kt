package com.order.orderlist.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.network.model.orderlist.OrderListResponse
import com.order.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_order_list.view.*

class OrderListAdapter(
    private val orderListResponse: List<OrderListResponse>
) : RecyclerView.Adapter<OrderListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        OrderListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_order_list,
                parent,
                false
            )
        )

    override fun getItemCount() = orderListResponse.size

    override fun onBindViewHolder(holder: OrderListViewHolder, position: Int) =
        holder.bind(orderListResponse[position])
}

class OrderListViewHolder(override val containerView: View) :
    RecyclerView.ViewHolder(containerView),
    LayoutContainer {
    fun bind(orderList: OrderListResponse) {
        with(itemView) {
            tvOrderProductListPrice.text = orderList.price.toString()
            tvOrderProductListName.text = orderList.name
            tvOrderProductListDescription.text = orderList.description
        }

        Glide.with(itemView.context)
            .load(orderList.photo)
            .circleCrop()
            .into(itemView.ivOrderProductList)
    }
}

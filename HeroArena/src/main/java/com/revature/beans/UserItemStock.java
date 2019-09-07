package com.revature.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="player_items")
@JsonIgnoreProperties(value = {"id", "user"})
public class UserItemStock
{
    @EmbeddedId
    private UserItemStockId id = new UserItemStockId();
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="player_id", insertable=false, updatable=false)
    @MapsId("playerId")
    private User user;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="item_id", insertable=false, updatable=false)
    @MapsId("itemId")
    private Item item;
    private Integer amount;


    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Item getItem()
    {
        return item;
    }

    public void setItem(Item item)
    {
        this.item = item;
    }

    public Integer getAmount()
    {
        return amount;
    }

    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserItemStock that = (UserItemStock) o;

        if (user != null && that.user != null)
        {
            if (user.getId() != that.user.getId())
                return false;  // Both users are not null, but have different IDs
        }
        else if (user != that.user)
            return false;  // Only one of the users is null.

        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        return amount != null ? amount.equals(that.amount) : that.amount == null;
    }

    @Override
    public int hashCode()
    {
        int result = user != null && user.getId() != null ? user.getId().hashCode() : 0;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "UserItemStock{" +
                "user=" + (user != null ? user.getId() : null) +
                ", item=" + item +
                ", amount=" + amount +
                '}';
    }
}

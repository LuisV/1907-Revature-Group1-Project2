package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserItemStockId implements Serializable
{
    @Column(name="player_id")
    private long playerId;
    @Column(name="item_id")
    private long itemId;

    public UserItemStockId()
    {
    }

    public long getPlayerId()
    {
        return playerId;
    }

    public void setPlayerId(long playerId)
    {
        this.playerId = playerId;
    }

    public long getItemId()
    {
        return itemId;
    }

    public void setItemId(long itemId)
    {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserItemStockId that = (UserItemStockId) o;

        if (playerId != that.playerId) return false;
        return itemId == that.itemId;
    }

    @Override
    public int hashCode()
    {
        int result = (int) (playerId ^ (playerId >>> 32));
        result = 31 * result + (int) (itemId ^ (itemId >>> 32));
        return result;
    }

    @Override
    public String toString()
    {
        return "UserItemStockId{" +
                "playerId=" + playerId +
                ", itemId=" + itemId +
                '}';
    }
}

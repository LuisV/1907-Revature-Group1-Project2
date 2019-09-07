package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserItemStockId implements Serializable
{
    private Integer playerId;
    private Integer itemId;

    public UserItemStockId()
    {
    }

    public Integer getPlayerId()
    {
        return playerId;
    }

    public void setPlayerId(Integer playerId)
    {
        this.playerId = playerId;
    }

    public Integer getItemId()
    {
        return itemId;
    }

    public void setItemId(Integer itemId)
    {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserItemStockId that = (UserItemStockId) o;

        if (playerId != null ? !playerId.equals(that.playerId) : that.playerId != null) return false;
        return itemId != null ? itemId.equals(that.itemId) : that.itemId == null;
    }

    @Override
    public int hashCode()
    {
        int result = playerId != null ? playerId.hashCode() : 0;
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
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

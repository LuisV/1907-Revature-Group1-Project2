package com.revature.beans;

import javax.persistence.*;

@Entity
@Table(name="items")
public class Item
{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="items")
    @SequenceGenerator(name="items", sequenceName="item_seq", allocationSize=1)
    private Integer id;
    private String name;
    private String description;
    @Column(name="effect_health")
    private Integer healthOffset;
    @Column(name="effect_xp")
    private Integer xpOffset;
    private Integer price;

    public Item()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Integer getHealthOffset()
    {
        return healthOffset;
    }

    public void setHealthOffset(Integer healthOffset)
    {
        this.healthOffset = healthOffset;
    }

    public Integer getXpOffset()
    {
        return xpOffset;
    }

    public void setXpOffset(Integer xpOffset)
    {
        this.xpOffset = xpOffset;
    }

    public Integer getPrice()
    {
        return price;
    }

    public void setPrice(Integer price)
    {
        this.price = price;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != null ? !id.equals(item.id) : item.id != null) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        if (description != null ? !description.equals(item.description) : item.description != null) return false;
        if (healthOffset != null ? !healthOffset.equals(item.healthOffset) : item.healthOffset != null) return false;
        if (xpOffset != null ? !xpOffset.equals(item.xpOffset) : item.xpOffset != null) return false;
        return price != null ? price.equals(item.price) : item.price == null;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (healthOffset != null ? healthOffset.hashCode() : 0);
        result = 31 * result + (xpOffset != null ? xpOffset.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", healthOffset=" + healthOffset +
                ", xpOffset=" + xpOffset +
                ", price=" + price +
                '}';
    }
}

package com.cssd.cssdecommerceapp.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Table
@Entity
public class Cart implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartID")
    private long id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerID")
    Customer customerID;

//    @Column(name="quantity")
//    private int quantity;

    @OneToMany(mappedBy = "cart")
    Set<CartItems> items;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    public Set<CartItems> getItems() {
        return items;
    }

    public void setItems(Set<CartItems> items) {
        this.items = items;
    }
}

@Embeddable
class CartItemsKey implements Serializable{
    @Column(name = "cartID")
    Long cartID;

    @Column(name = "itemID")
    Long itemID;
}

@Entity
class CartItems{
    @EmbeddedId
    CartItemsKey id;

    @ManyToOne
    @MapsId("cartID")
    @JoinColumn(name = "cartID")
    Cart cart;

    @ManyToOne
    @MapsId("itemID")
    @JoinColumn(name="itemID")
    Items item;

    @Column(name="quantity")
    int quantity;
}
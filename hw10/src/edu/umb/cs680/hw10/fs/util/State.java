package edu.umb.cs680.hw10.fs.util;

public interface State{
    public void login(EncryptedString pwd);
    public void logout();
}
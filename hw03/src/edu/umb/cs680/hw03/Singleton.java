package edu.umb.cs680.hw03;

public class Singleton {

        private Singleton() {};
        private static edu.umb.cs680.hw03.Singleton instance = null;

        public static edu.umb.cs680.hw03.Singleton getInstance() {
            if(instance == null) {
                instance = new edu.umb.cs680.hw03.Singleton();
            }
            return instance;
        }

}

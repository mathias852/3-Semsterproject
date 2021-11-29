package org.example.BeerMachine.BeerMachineCommunication;

public enum TypeSpeed {
        Pilsner( 600),
        Wheat( 300),
        IPA(150),
        Stout( 200),
        Ale(100),
        Alcohole_Free(125);

        public final float Value;

        private TypeSpeed(float value) {
            Value = value;
        }

        public float getTypeValue(){
            return Value;
        }
}

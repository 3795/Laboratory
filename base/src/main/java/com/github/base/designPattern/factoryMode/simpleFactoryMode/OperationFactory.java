package com.github.base.designPattern.factoryMode.simpleFactoryMode;

/**
 * 简单工厂模式的实现
 */
public class OperationFactory {

    public static Operation createOperation(String operationType) {
        Operation operation;
        switch(operationType) {
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
            case "*":
                operation = new OperationMul();
                break;
            case "/":
                operation = new OperationDiv();
                break;
            default:
                throw new UnsupportedOperationException("不支持该操作");
        }
        return operation;
    }

    public static void main(String[] args) {
        Operation operationAdd = OperationFactory.createOperation("+");
        operationAdd.setValue1(1);
        operationAdd.setValue2(2);
        System.out.println(operationAdd.getResult());
    }
}

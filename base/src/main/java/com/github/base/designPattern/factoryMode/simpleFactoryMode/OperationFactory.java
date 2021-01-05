package com.github.base.designPattern.factoryMode.simpleFactoryMode;

/**
 * 简单工厂模式的实现
 * 使用静态方法，通过接收不同的参数来返回不同的对象实例
 * 不修改代码的话，不能做到扩展
 */
public class OperationFactory {

    public static Operation createOperation(String operationType) {
        Operation operation;
        switch (operationType) {
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

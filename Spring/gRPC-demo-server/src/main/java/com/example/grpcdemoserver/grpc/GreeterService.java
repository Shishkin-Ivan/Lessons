package com.example.grpcdemoserver.grpc;

import com.example.grpcdemoserver.grpc.GreeterGrpc;
import com.example.grpcdemoserver.grpc.HelloWorldProto;
import io.grpc.stub.StreamObserver;

import org.springframework.grpc.server.service.GrpcService;

@GrpcService // аннотация из spring-boot-starter-grpc
public class GreeterService extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloWorldProto.HelloRequest request,
                         StreamObserver<HelloWorldProto.HelloReply> responseObserver) {
        String greeting = "Привет, " + request.getName() + " " + request.getSurname();
        HelloWorldProto.HelloReply reply = HelloWorldProto.HelloReply
                .newBuilder()
                .setMessage(greeting)
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void sayHelloAgain(HelloWorldProto.HelloRequest request,
                              StreamObserver<HelloWorldProto.HelloReply> responseObserver) {
        String greeting = "Снова привет, " + request.getName();
        HelloWorldProto.HelloReply reply = HelloWorldProto.HelloReply
                .newBuilder()
                .setMessage(greeting)
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}

package com.github.base.io.FileCopyDemo;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created By Q.Hao
 * Description:
 * Created At 2019/12/1
 */

interface FileCopyRunner {
    /**
     * 拷贝文件的接口
     *
     * @param source
     * @param target
     */
    void copyFile(File source, File target) throws Exception;
}

public class FileCopyDemo {

    /**
     * 关闭文件资源
     *
     * @param closeable
     * @throws IOException
     */
    private static void close(Closeable closeable) throws IOException {
        if (closeable != null) {
            closeable.close();
        }
    }

    @Override
    public String toString() {
        return "FileCopyDemo{}";
    }

    public static void main(String[] args) {

        // 使用最基本的文件流读写
        FileCopyRunner noBufferStreamCopy = new FileCopyRunner() {
            @Override
            public void copyFile(File source, File target) throws Exception {
                InputStream inputStream = null;
                OutputStream outputStream = null;
                try {
                    inputStream = new FileInputStream(source);
                    outputStream = new FileOutputStream(target);
                    // 每次从流中读取一个字节
                    int result;
                    while ((result = inputStream.read()) != -1) {
                        outputStream.write(result);
                    }
                } finally {
                    close(inputStream);
                    close(outputStream);
                }
            }

            @Override
            public String toString() {
                return "noBufferStreamCopy";
            }
        };

        // 基于Buffer的文件流读写
        FileCopyRunner bufferStreamCopy = new FileCopyRunner() {
            @Override
            public void copyFile(File source, File target) throws Exception {
                InputStream inputStream = null;
                OutputStream outputStream = null;

                try {
                    inputStream = new BufferedInputStream(new FileInputStream(source));
                    outputStream = new BufferedOutputStream(new FileOutputStream(target));

                    // 声明缓冲区
                    byte[] buffer = new byte[1024];
                    // 每次将文件流读取到Buffer中，返回读取的长度
                    int result;
                    while ((result = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, result);
                    }
                } finally {
                    close(inputStream);
                    close(outputStream);
                }
            }

            @Override
            public String toString() {
                return "bufferStreamCopy";
            }
        };

        // 基于NIO的文件拷贝
        FileCopyRunner nioBufferCopy = new FileCopyRunner() {
            @Override
            public void copyFile(File source, File target) throws Exception {
                FileChannel inChannel = null;
                FileChannel outChannel = null;

                try {
                    inChannel = new FileInputStream(source).getChannel();
                    outChannel = new FileOutputStream(target).getChannel();

                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    while (inChannel.read(buffer) != -1) {      // 使用通道将内容读取到Buffer中
                        buffer.flip();      // 将Buffer从读模式改为写模式
                        while (buffer.hasRemaining()) {
                            outChannel.write(buffer);
                        }
                        buffer.clear();     // 将Buffer从写模式改为读模式
                    }
                } finally {
                    close(inChannel);
                    close(outChannel);
                }
            }

            @Override
            public String toString() {
                return "nioBufferCopy";
            }
        };
    }

    // 基于通道间相互传递的拷贝方式
    FileCopyRunner nioTransferCopy = new FileCopyRunner() {
        @Override
        public void copyFile(File source, File target) throws Exception {
            FileChannel inChannel = null;
            FileChannel outChannel = null;

            try {
                inChannel = new FileInputStream(source).getChannel();
                outChannel = new FileOutputStream(target).getChannel();
                long transferred = 0L;
                long size = inChannel.size();
                while (transferred != size) {       // 确保将输入通道中的内容全部读取完
                    transferred += inChannel.transferTo(0, size, outChannel);
                }
            } finally {
                close(inChannel);
                close(outChannel);
            }
        }

        @Override
        public String toString() {
            return "nioTransferCopy";
        }
    };
}

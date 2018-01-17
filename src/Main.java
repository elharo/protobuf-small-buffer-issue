import com.google.protobuf.Message;

import java.io.IOException;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        write(Test.Request.newBuilder().setType(Test.Type.PING).build());
        write(Test.Request.newBuilder().setType(Test.Type.DELETE).setFilename("hello").build());
        write(Test.Request.newBuilder().setType(Test.Type.READ).setCompression(Test.Compression.LZ4).setFilename("hello").build());
    }

    private static void write(Message msg) throws IOException {
        TestOutputStream os = new TestOutputStream();

        msg.writeDelimitedTo(os);

        System.out.println("Serialized size: " + msg.getSerializedSize() + ", writes: " + os.writes);
    }

    static class TestOutputStream extends OutputStream {
        int writes;

        @Override
        public void write(int b) {
            writes++;
        }

        @Override
        public void write(byte[] b) {
            writes++;
        }

        @Override
        public void write(byte[] b, int off, int len) {
            writes++;
        }
    }
}

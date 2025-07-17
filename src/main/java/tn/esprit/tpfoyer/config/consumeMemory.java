package tn.esprit.tpfoyer.config;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

public class consumeMemory {

    @PostConstruct
    public void consumeMemory() {
        List<byte[]> heap = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            heap.add(new byte[1024 * 1024]); // 1 MB x 1000 = ~1 GB
            try { Thread.sleep(200); } catch (InterruptedException e) { }
        }
    }
}

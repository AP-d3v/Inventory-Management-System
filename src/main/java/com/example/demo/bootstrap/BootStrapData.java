package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        OutsourcedPart macroCore = new OutsourcedPart();
        macroCore.setCompanyName("MacroCore ");
        macroCore.setName("100mm f/2.8 Lens");
        macroCore.setMinInv(20);
        macroCore.setMaxInv(1);
        macroCore.setInv(5);
        macroCore.setPrice(749.99);

        OutsourcedPart steadyGrip = new OutsourcedPart();
        steadyGrip.setCompanyName("SteadyGrip");
        steadyGrip.setName("Carbon Fiber Tripod");
        steadyGrip.setMaxInv(15);
        steadyGrip.setMinInv(2);
        steadyGrip.setInv(3);
        steadyGrip.setPrice(149.99);

        OutsourcedPart clearSight = new OutsourcedPart();
        clearSight.setCompanyName("ClearSight");
        clearSight.setName("UV Lens Filter");
        clearSight.setMaxInv(25);
        clearSight.setMinInv(3);
        clearSight.setInv(7);
        clearSight.setPrice(149.99);

        InhousePart speedFlash = new InhousePart();
        speedFlash.setName("200 External Flash");
        speedFlash.setMaxInv(35);
        speedFlash.setMinInv(1);
        speedFlash.setInv(3);
        speedFlash.setPrice(249.99);

        OutsourcedPart uvLensMultiPack = new OutsourcedPart();
        uvLensMultiPack.setName("UV Lens MultiPack(3 per pack)");
        uvLensMultiPack.setMaxInv(20);
        uvLensMultiPack.setMinInv(1);
        uvLensMultiPack.setInv(1);
        uvLensMultiPack.setPrice(450.99);

        if(partRepository.count() == 0) {

            partRepository.save(macroCore);
            partRepository.save(steadyGrip);
            partRepository.save(clearSight);
            partRepository.save(speedFlash);
            partRepository.save(uvLensMultiPack);
        }


        Product novaShot = new Product("Apex Pro DSLR", 1199.99, 5);
        Product lumixor = new Product("Lumixor Z5 Compact Camera", 499.99, 8);
        Product horizon = new Product("Horizon Mark II Film Camera", 699.99, 3);
        Product aurora = new Product("Aurora X100 Mirrorless Camera", 899.99, 3);
        Product polaris = new Product("Polaris 2400 Pro Flex Camera", 899.99, 3);

        if (productRepository.count() == 0) {

            productRepository.save(novaShot);
            productRepository.save(lumixor);
            productRepository.save(horizon);
            productRepository.save(aurora);
            productRepository.save(polaris);

        }




       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}

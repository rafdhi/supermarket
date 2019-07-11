package com.eksad.supermarket;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.supermarket.dao.BrandDao;
import com.eksad.supermarket.dao.CashierDAO;
import com.eksad.supermarket.dao.CustomerDAO;
import com.eksad.supermarket.dao.PersonDao;
import com.eksad.supermarket.dao.ProductDao;
import com.eksad.supermarket.dao.ProductElectronicDAO;
import com.eksad.supermarket.dao.ProductGroceryDAO;
import com.eksad.supermarket.dao.TransactionDao;
import com.eksad.supermarket.entity.Brand;
import com.eksad.supermarket.entity.Person;
import com.eksad.supermarket.entity.PersonAddress;
import com.eksad.supermarket.entity.Product;
import com.eksad.supermarket.entity.Transaction;
import com.eksad.supermarket.entity.TransactionDetail;

@SpringBootApplication
public class SupermarketApplication  implements ApplicationRunner { // menandakan bahwa ini adalah class yang pertama kali akan dirunning setelah konfigurasi(string) selesai
	
	// jadiiiii ApplicationRunner itu buat biar bisa nge running method yang gaada static void main nyaaa
	// kan kalo gaada static void main nya gabisa di running aplikasinyaa

	public static void main(String[] args) {
		SpringApplication.run(SupermarketApplication.class, args);
	}
	
	@Autowired
	private BrandDao brandDao;
	
	@Autowired // harus satu2, gabisa nyampur sama autowired dari brandDao
	private ProductDao productDao;
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private TransactionDao transactionDao;
	
	@Autowired
	private CashierDAO cashierDAO;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private ProductElectronicDAO productElectronicDAO;
	
	@Autowired
	private ProductGroceryDAO productGroceryDAO;

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		Page<Person> page = personDao.findAll(PageRequest.of(2, 10, Sort.by("name")));
		
		System.out.println("Total element : " + page.getTotalElements());
		System.out.println("Total page : " + page.getTotalPages());
		page.forEach(System.out::println);
//		personDao.findAll(Sort.by("name")).forEach(System.out::println);
		
//		Product product = new Product();
//		product.setName("Cimory Susu Coklat");
//		product.setPrice(new BigDecimal(15000));
		
// 		kenapa 1L? kalo 1 doang dia kebacanya int, padahal di definisiinnya tuh long, biar gampang tambahin L aja dibelakang angkanya
//		kalo double pakein aja D dibelakang angkanya
//		Brand brand = brandDao.findById(1L).get(); // untuk manggil barangnya
//		Brand brand = brandDao.findById(1L).orElse(null); // kalo kita ga yakin produknya ada atau engga
//		product.setBrand(brand);
		
//		productDao.save(product);
		
		//productDao.findAll().forEach(System.out::println);
		
//		brandDao.findAll().forEach(System.out::println); // ini adalah kependekan dari cara yang dibawah, jadi :: itu sama aja kayak lambda
		
		// ini adalah kepanjangan dari cara diatas
//		Iterable<Brand> brands = brandDao.findAll();
//		brands.forEach(brand -> System.out.println(brand));
		
//		Person person = new Person();
//		person.setName("Jane Fulan");
//		
//		PersonAddress address = new PersonAddress();
//		address.setAddress("Kebun Raya");
//		address.setCity("Bogor");
//		
//		person.setAddress(address);
//		address.setPerson(person);
//		
//		personDao.save(person);
		/*personDao.findAll().forEach(System.out::println);
		
		Transaction transaction = new Transaction();
		transaction.setDate(new Date());
		transaction.setRemark("Test Transaction");
		transaction.setDetails(new HashSet<TransactionDetail>());
		
		TransactionDetail detail1 = new TransactionDetail();
		detail1.setProduct(productDao.findById(3L).get());
		detail1.setQuantity(3);
		detail1.setTransaction(transaction);
		transaction.getDetails().add(detail1);
		
		TransactionDetail detail2 = new TransactionDetail();
		detail2.setProduct(productDao.findById(4L).get());
		detail2.setQuantity(5);
		detail2.setTransaction(transaction);
		transaction.getDetails().add(detail2);
		
		transactionDao.save(transaction);*/
//		transactionDao.findAll().forEach(System.out::println);
		
		/*Transaction transaction1 = transactionDao.findById(2L).get();
		System.out.println("===DONE GET TRANS===");
		transaction1.getDetails().size();
		System.out.println(transaction1.getDetails().size());*/
		
		
		
		//transactionDao.findAll().forEach(System.out::println);
		
		/*Brand brand = brandDao.findByName("Nestle").stream()
				.findFirst()
				.orElse(null) ;
		
		if(brand != null) {
			brand.setProductType("Food and Bevarage");
			brandDao.save(brand);
		}
		
		brandDao.findAll().forEach(System.out::println);*/
		
		/*List<Brand> brand = brandDao.findAllByOrderByName();
		System.out.println(brand); */
		
		/*Brand brand1 = new Brand();
		brand1.setName("Brand test 1");
		brand1.setProductType("Test #1");
		brandDao.save(brand1);
		
		String bikinEror = null;
		bikinEror.toString();
		
		Brand brand2 = new Brand();
		brand2.setName("Brand test 2");
		brand2.setProductType("Test #2");
		brandDao.save(brand2);*/
		
		//brandDao.findAll().forEach(System.out::println);
		
		/*System.out.println("Cashier");
		cashierDAO.findAll().forEach(System.out::println);
		
		System.out.println("Customer");
		customerDAO.findAll().forEach(System.out::println);
		*/
		
		/*System.out.println("Electronic");
		productElectronicDAO.findAll().forEach(System.out::println);
		System.out.println("Grocery");
		productGroceryDAO.findAll().forEach(System.out::println);
		System.out.println("Product");
		productDao.findAll().forEach(System.out::println);*/
		//System.out.println(transactionDao.findTotalItemByTransactionId(1L));
//		List<Object[]> totals =
//				transactionDao.findTotalNominalPerTransaction();
//		for(Object[] total: totals) {
//			System.out.println("id: " + total[0]);
//			System.out.println("total: " + total[1]);
//		}
		
	}
	
	
	

}

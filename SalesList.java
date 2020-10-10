package list;



public class SalesList {
	SellerNode head;
	int membershipDiscountPercentage = 10;
	int commissionProfitPercentage = 25;
	int size;
	
	public void add(Seller seller){
		
		SellerNode newSeller = new SellerNode();
		seller.balance = seller.membershipInitialFee - (seller.membershipInitialFee*membershipDiscountPercentage)/100;
		newSeller.seller = seller;
		
		if (head== null){
			head = newSeller;
		}
		
		else {
			SellerNode tmp = head;
			while(tmp.next!=null){
				tmp = tmp.next;
			}
			tmp.next = newSeller;		
		}
		size++;
		
		
	}// end add
	
	public void getBalance () {
		SellerNode tmp = head;
		while(tmp.next != null) {
			tmp = tmp.next;
		}
		pointer(size-1, tmp.seller.balance);
	}
	
	
	public void pointer (int i, int value) {
		
		if(i == 1) {
			listar();
		}else {
			SellerNode tmp = head;
			int cont=0;
			while(cont < i-2) {
				tmp = tmp.next;
				cont++;
			}
			
			if(i < size -1) {
				tmp.seller.balance = tmp.seller.balance + ((value * commissionProfitPercentage)/100) + ((tmp.next.seller.balance *commissionProfitPercentage)/100);
			} else {
				tmp.next.seller.balance = tmp.next.seller.balance + ((value *commissionProfitPercentage)/100);
				tmp.seller.balance = tmp.seller.balance + ((value * commissionProfitPercentage)/100) + ((tmp.next.seller.balance *commissionProfitPercentage)/100);
			}
			
			pointer(i-1, tmp.next.seller.balance);
			
		}	
		
	}
	
	public void higher() {
			SellerNode tmp = head;
			Seller higher = head.seller;
			while (tmp.next != null) {
				if(tmp.seller.balance > higher.balance) {
					higher = tmp.seller;
				}
				tmp = tmp.next;
			}
			System.out.println("Biggest balance "+higher.name+" de "+higher.balance);
	}
	
	public void less() {
			SellerNode tmp = head;
			Seller less = head.seller;
			while (tmp.next != null) {
				if(tmp.seller.balance < less.balance) {
					less = tmp.seller;
				}
				tmp = tmp.next;
			}
			if(tmp.seller.balance < less.balance) {
				less = tmp.seller;
			}
			System.out.println("smaller balance "+less.name+" de "+less.balance);
				
	}
	
	
	public void listar () {
		SellerNode tmp = head;
		while(tmp.next != null) {
			System.out.println("user "+  tmp.seller.name + ": fee " + tmp.seller.membershipInitialFee + " Actual balance "+tmp.seller.balance);
			tmp = tmp.next;
		}
		System.out.println("user "+  tmp.seller.name + ": fee " + tmp.seller.membershipInitialFee + " Actual balance "+tmp.seller.balance);
	}
	
	
}


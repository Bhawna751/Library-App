class PaymentInfoRequest{
    amount: number;
    currency: string;
    recieptEmail: string | undefined;

    constructor(amount: number, currency: string, receiptEmail: string | undefined){
        this.amount = amount;
        this.currency = currency;
        this.recieptEmail = receiptEmail;
    }
}
export default PaymentInfoRequest;
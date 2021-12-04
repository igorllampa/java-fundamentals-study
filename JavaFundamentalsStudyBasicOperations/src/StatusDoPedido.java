
public enum StatusDoPedido {

	ORCAMENTO(0),
	PEDIDO_PENDENTE(1),
	PEDIDO_ENTREGUE(2),
	PEDIDO_CONCLUIDO(3);
		
	
	private int codigo;
	
	private StatusDoPedido(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
}

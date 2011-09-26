package plaid.fastrutime.reference;

public abstract class SingleValue extends AbstractObjectValue {
	@Override
	public ListValue addValue(SingleValue other) {
		return new ListValue(this, other);
	}
}

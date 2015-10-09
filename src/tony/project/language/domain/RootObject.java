package tony.project.language.domain;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

import tony.project.language.initial.Initial;

public class RootObject<T> {

	private static DynamoDB dynamoDB;
	private static AmazonDynamoDBClient client;
	private static DynamoDBMapper mapper;

	private Class<T> clazz;

	public RootObject() {

		Type superClass = getClass().getGenericSuperclass();

		if (superClass instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) superClass;

			Type[] typeArgs = parameterizedType.getActualTypeArguments();

			if (typeArgs != null && typeArgs.length > 0) {
				if (typeArgs[0] instanceof Class) {

					clazz = (Class<T>) typeArgs[0];
				}

			}

		}

	}

	
	public void saveByMapper(T entity) {
		try {
			client = Initial.getClient();
			mapper = new DynamoDBMapper(client);
			mapper.save(entity);
		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}
	
	
	
	public T loadByMapper(Integer hashKey) {
		client = Initial.getClient();
		mapper = new DynamoDBMapper(client);

		return mapper.load(clazz, hashKey);
	}
	

	
	public T loadByMapper(String hashKey) {
		client = Initial.getClient();
		mapper = new DynamoDBMapper(client);
		
		return mapper.load(clazz, hashKey);
	}

	
	
	
	
	
	public void deleteByMapper(Integer hashKey){
		T item = null;
		
		try {
			client = Initial.getClient();
			mapper = new DynamoDBMapper(client);
			item = loadByMapper(hashKey);
			
			mapper.delete(item);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	
	public void deleteByMapper(String hashKey){
		T item = null;
		
		try {
			client = Initial.getClient();
			mapper = new DynamoDBMapper(client);
			item = loadByMapper(hashKey);
			
			mapper.delete(item);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
}

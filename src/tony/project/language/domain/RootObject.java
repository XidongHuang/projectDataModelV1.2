package tony.project.language.domain;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

import tony.project.language.initial.Initial;

public class RootObject<T> {

	private static DynamoDB dynamoDB;
	private static AmazonDynamoDBClient client;
	private static DynamoDBMapper mapper;

	private static ObjectMapper objectMapper;

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

	public T loadByMapper(String hashKey, String rangeKey) {
		client = Initial.getClient();
		mapper = new DynamoDBMapper(client);

		return mapper.load(clazz, hashKey, rangeKey);
	}

	public T loadByMapper(Integer hashKey, String rangeKey) {
		client = Initial.getClient();
		mapper = new DynamoDBMapper(client);

		return mapper.load(clazz, hashKey, rangeKey);
	}

	public T loadByMapper(String hashKey, Integer rangeKey) {
		client = Initial.getClient();
		mapper = new DynamoDBMapper(client);

		return mapper.load(clazz, hashKey, rangeKey);
	}

	public T loadByMapper(Integer hashKey, Integer rangeKey) {
		client = Initial.getClient();
		mapper = new DynamoDBMapper(client);

		return mapper.load(clazz, hashKey, rangeKey);
	}

	public void deleteByMapper(Integer hashKey) {
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

	public void deleteByMapper(String hashKey) {
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

	public void deleteByMapper(String hashKey, Integer rangeKey) {
		T item = null;

		try {
			client = Initial.getClient();
			mapper = new DynamoDBMapper(client);
			item = loadByMapper(hashKey, rangeKey);

			mapper.delete(item);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void deleteByMapper(Integer hashKey, Integer rangeKey) {
		T item = null;

		try {
			client = Initial.getClient();
			mapper = new DynamoDBMapper(client);
			item = loadByMapper(hashKey, rangeKey);

			mapper.delete(item);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void deleteByMapper(Integer hashKey, String rangeKey) {
		T item = null;

		try {
			client = Initial.getClient();
			mapper = new DynamoDBMapper(client);
			item = loadByMapper(hashKey, rangeKey);

			mapper.delete(item);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void deleteByMapper(String hashKey, String rangeKey) {
		T item = null;

		try {
			client = Initial.getClient();
			mapper = new DynamoDBMapper(client);
			item = loadByMapper(hashKey, rangeKey);

			mapper.delete(item);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public T getAnObjectFromJSON(String json) {

		T object = null;
		objectMapper = new ObjectMapper();

		try {

			object = objectMapper.readValue(json, clazz);
			return object;

		} catch (JsonParseException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return object;
	}

	public List<T> getObjectsFromJSON(String json) {

		List<T> objects = null;
		objectMapper = new ObjectMapper();

		try {

//			System.out.println(json);
//			System.out.println(clazz.getName());
//			T object = (T) getClass().newInstance();
//			System.out.println(object instanceof ScoresDetail);
//			System.out.println();
			objects = objectMapper.readValue(json, new TypeReference<List<T>>(){});;
//			System.out.println(objects == null);

		} catch (JsonParseException e) {

			System.err.println(e.getMessage());
			e.printStackTrace();

		} catch (JsonMappingException e) {

			System.err.println(e.getMessage());
			e.printStackTrace();

		} catch (IOException e) {

			System.err.println(e.getMessage());
			e.printStackTrace();

		} 
//			catch (InstantiationException e) {
//			System.err.println(e.getMessage());
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			System.err.println(e.getMessage());
//			e.printStackTrace();
//		}

		return objects;

	}

}

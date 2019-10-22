import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Solution
{

		private static class Retailer
		{
			private Long id;

				public Retailer(Long id)
				{
						this.id = id;
				}

				public Long getId()
				{
						return id;
				}

				public void setId(Long id)
				{
						this.id = id;
				}
		}

		private static class SimpleClass
		{
				private String id = "1";

				private String name = "LOL";

				private Retailer retailer;

				public Retailer getRetailer()
				{
						return retailer;
				}

				public void setRetailer(Retailer retailer)
				{
						this.retailer = retailer;
				}

				public String getId()
				{
						return id;
				}

				public void setId(String id)
				{
						this.id = id;
				}

				public String getName()
				{
						return name;
				}

				public void setName(String name)
				{
						this.name = name;
				}
		}


		public static void send() throws IllegalAccessException
		{
				class MessageInfo
				{
						Map<String, Object> map = new HashMap<>();

						@Override public int hashCode()
						{
								return 1;
						}

						@Override public boolean equals(Object obj)
						{
								return true;
						}
				}
				System.out.println("Hi");
				MessageInfo messageInfo = new MessageInfo();
				messageInfo.map.put("name", "123");
				messageInfo.map.put("templateID", "1");
				consume(messageInfo);
		}

		public static void consume(Object object) throws IllegalAccessException
		{
				Map<String, Object> map = new HashMap<>();
				for (Field field : object.getClass().getDeclaredFields())
				{
						field.setAccessible(true);
						map.put(field.getName(), field.get(object));
				}
		}



		public static void main(String[] args) throws IllegalAccessException
		{
				Map<String, Object> map = new HashMap<>();
				SimpleClass simpleClass = new SimpleClass();
				simpleClass.setId("123");
				simpleClass.setName("Asasdasd");
				simpleClass.setRetailer(new Retailer(1L));
				for (Field field : simpleClass.getClass().getDeclaredFields())
				{
						field.setAccessible(true);
						map.put(field.getName(), field.get(simpleClass));
				}
				send();
		}
}

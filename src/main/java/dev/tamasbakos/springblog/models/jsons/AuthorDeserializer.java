package dev.tamasbakos.springblog.models.jsons;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import dev.tamasbakos.springblog.models.Author;
import java.io.IOException;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@JsonComponent
public class AuthorDeserializer extends JsonDeserializer<AggregateReference<Author, Integer>> {

  @Override
  public AggregateReference<Author, Integer> deserialize(JsonParser jsonParser,
      DeserializationContext deserializationContext) throws IOException, JacksonException {
    TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
    return AggregateReference.to(Integer.parseInt(treeNode.get("id").toString()));
  }

}
